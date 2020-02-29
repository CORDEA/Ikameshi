package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor

class FetchMusics(
    private val repository: MusicRepository
) {
    private val _reader = PublishProcessor.create<Unit>()
    val reader: Flowable<Action.FetchMusics> =
        _reader
            .flatMap { repository.findAll().toFlowable() }
            .map { Action.FetchMusics(it) }

    fun dispatch() {
        _reader.offer(Unit)
    }
}