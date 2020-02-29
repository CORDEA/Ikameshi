package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor

class LikeMusic(
    private val repository: LikeRepository
) {
    private val _reader = PublishProcessor.create<Long>()
    val reader: Flowable<Action> =
        _reader
            .flatMap {
                repository.like()
                    .andThen(Flowable.just(it))
            }
            .map { Action.LikeMusic(it) }

    fun dispatch(id: Long) {
        _reader.offer(id)
    }
}
