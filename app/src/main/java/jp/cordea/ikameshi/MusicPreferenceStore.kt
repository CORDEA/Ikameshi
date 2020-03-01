package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType

class MusicPreferenceStore(
    private val dispatcher: Dispatcher,
    private val preferenceRepository: MusicPreferenceRepository
) {
    private val likeMusic: Flowable<MusicPreferenceResult> =
        dispatcher.reader
            .ofType<Action.LikeMusic>()
            .flatMap {
                preferenceRepository.like()
                    .andThen(Flowable.just<MusicPreferenceResult>(MusicPreferenceResult.Like(it.id)))
                    .onErrorReturnItem(MusicPreferenceResult.Failure(it.id))
            }
    private val unlikeMusic: Flowable<MusicPreferenceResult> =
        dispatcher.reader
            .ofType<Action.UnlikeMusic>()
            .flatMap {
                preferenceRepository.unlike()
                    .andThen(Flowable.just<MusicPreferenceResult>(MusicPreferenceResult.Unlike(it.id)))
                    .onErrorReturnItem(MusicPreferenceResult.Failure(it.id))
            }

    fun onResult(): Flowable<MusicPreferenceResult> =
        Flowable
            .merge(
                dispatcher.reader
                    .ofType<Action.LikeMusic>()
                    .map { MusicPreferenceResult.Loading(it.id) },
                likeMusic,
                dispatcher.reader
                    .ofType<Action.UnlikeMusic>()
                    .map { MusicPreferenceResult.Loading(it.id) },
                unlikeMusic
            )
            .share()
}
