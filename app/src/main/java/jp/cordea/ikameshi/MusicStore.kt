package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType

class MusicStore(
    private val dispatcher: Dispatcher,
    private val repository: MusicRepository
) {
    private val fetchMusicsEvent =
        dispatcher.reader.ofType<Action.FetchMusics>()
    private val fetchMusics: Flowable<MusicResult.FetchMusics> =
        fetchMusicsEvent
            .flatMap { repository.findAll().toFlowable() }
            .map<MusicResult.FetchMusics> { MusicResult.FetchMusics.Success(it) }
            .onErrorReturnItem(MusicResult.FetchMusics.Failure)
    private val fetchFavoriteMusics: Flowable<MusicResult.FetchFavoriteMusics> =
        dispatcher.reader.ofType<Action.FetchFavoriteMusics>()
            .flatMap {
                repository.findAll()
                    .flattenAsFlowable { it }
                    .filter { it.liked }
                    .toList()
                    .toFlowable()
            }
            .map<MusicResult.FetchFavoriteMusics> { MusicResult.FetchFavoriteMusics.Success(it) }
            .onErrorReturnItem(MusicResult.FetchFavoriteMusics.Failure)

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
                fetchFavoriteMusics
            )
}
