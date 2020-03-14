package jp.cordea.ikameshi.store

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType
import jp.cordea.ikameshi.action.Action
import jp.cordea.ikameshi.Dispatcher
import jp.cordea.ikameshi.repository.MusicPreferenceRepository
import jp.cordea.ikameshi.repository.MusicRepository

class MusicStore(
    private val dispatcher: Dispatcher,
    private val repository: MusicRepository,
    private val preferenceRepository: MusicPreferenceRepository
) {
    private val fetchMusicsEvent =
        dispatcher.reader.ofType<Action.FetchMusics>()
    private val fetchMusics: Flowable<MusicResult.FetchMusics> =
        fetchMusicsEvent
            .flatMap { repository.findAll().toFlowable() }
            .map<MusicResult.FetchMusics> {
                MusicResult.FetchMusics.Success(
                    it
                )
            }
            .onErrorReturnItem(MusicResult.FetchMusics.Failure)

    private val fetchFavoriteMusics: Flowable<MusicResult.FetchFavoriteMusics> =
        dispatcher.reader.ofType<Action.FetchFavoriteMusics>()
            .flatMap { findFavoriteMusics() }
    private val likeMusic: Flowable<MusicResult.ChangeFavoriteState> =
        dispatcher.reader
            .ofType<Action.LikeMusic>()
            .flatMap {
                preferenceRepository.like()
                    .andThen(
                        Flowable.just<MusicResult.ChangeFavoriteState>(
                            MusicResult.ChangeFavoriteState.Like(
                                it.id
                            )
                        )
                    )
                    .onErrorReturnItem(
                        MusicResult.ChangeFavoriteState.Failure(
                            it.id
                        )
                    )
            }
            .share()
    private val unlikeMusic: Flowable<MusicResult.ChangeFavoriteState> =
        dispatcher.reader
            .ofType<Action.UnlikeMusic>()
            .flatMap {
                preferenceRepository.unlike()
                    .andThen(
                        Flowable.just<MusicResult.ChangeFavoriteState>(
                            MusicResult.ChangeFavoriteState.Unlike(
                                it.id
                            )
                        )
                    )
                    .onErrorReturnItem(
                        MusicResult.ChangeFavoriteState.Failure(
                            it.id
                        )
                    )
            }
            .share()

    fun onMusicChanged(): Flowable<MusicResult.FetchMusics> =
        Flowable
            .merge(
                fetchMusicsEvent.map { MusicResult.FetchMusics.Loading },
                fetchMusics
            )

    fun onFavoriteMusicChanged(): Flowable<MusicResult.FetchFavoriteMusics> =
        Flowable
            .merge(
                dispatcher.reader
                    .ofType<Action.FetchFavoriteMusics>()
                    .map { MusicResult.FetchFavoriteMusics.Loading },
                fetchFavoriteMusics,
                likeMusic.flatMap { findFavoriteMusics() },
                unlikeMusic.flatMap { findFavoriteMusics() }
            )

    fun onFavoriteStateChanged(): Flowable<MusicResult.ChangeFavoriteState> =
        Flowable
            .merge(
                dispatcher.reader
                    .ofType<Action.LikeMusic>()
                    .map {
                        MusicResult.ChangeFavoriteState.Loading(
                            it.id
                        )
                    },
                likeMusic,
                dispatcher.reader
                    .ofType<Action.UnlikeMusic>()
                    .map {
                        MusicResult.ChangeFavoriteState.Loading(
                            it.id
                        )
                    },
                unlikeMusic
            )
            .share()

    private fun findFavoriteMusics() =
        repository.findAll()
            .flattenAsFlowable { it }
            .filter { it.liked }
            .toList()
            .toFlowable()
            .map<MusicResult.FetchFavoriteMusics> {
                MusicResult.FetchFavoriteMusics.Success(
                    it
                )
            }
            .onErrorReturnItem(MusicResult.FetchFavoriteMusics.Failure)
}
