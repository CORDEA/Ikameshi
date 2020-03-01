package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType

class LikeMusicStore(
    private val dispatcher: Dispatcher,
    private val likeRepository: LikeRepository
) {
    private val likeMusic: Flowable<LikeMusicResult> =
        dispatcher.reader
            .ofType<Action.LikeMusic>()
            .flatMap {
                likeRepository.like()
                    .andThen(Flowable.just<LikeMusicResult>(LikeMusicResult.Like(it.id)))
                    .onErrorReturnItem(LikeMusicResult.Failure(it.id))
            }
    private val unlikeMusic: Flowable<LikeMusicResult> =
        dispatcher.reader
            .ofType<Action.UnlikeMusic>()
            .flatMap {
                likeRepository.unlike()
                    .andThen(Flowable.just<LikeMusicResult>(LikeMusicResult.Unlike(it.id)))
                    .onErrorReturnItem(LikeMusicResult.Failure(it.id))
            }

    fun onResult(): Flowable<LikeMusicResult> =
        Flowable
            .merge(
                dispatcher.reader
                    .ofType<Action.LikeMusic>()
                    .map { LikeMusicResult.Loading(it.id) },
                likeMusic,
                dispatcher.reader
                    .ofType<Action.UnlikeMusic>()
                    .map { LikeMusicResult.Loading(it.id) },
                unlikeMusic
            )
            .share()
}
