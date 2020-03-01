package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor

class Dispatcher {
    private val _reader = PublishProcessor.create<Action>()
    val reader: Flowable<Action> = _reader

    fun dispatch(action: Action) {
        _reader.offer(action)
    }
}
