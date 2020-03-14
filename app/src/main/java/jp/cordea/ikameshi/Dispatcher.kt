package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor
import jp.cordea.ikameshi.action.Action

class Dispatcher {
    private val _reader = PublishProcessor.create<Action>()
    val reader: Flowable<Action> = _reader.share()

    fun dispatch(action: Action) {
        _reader.offer(action)
    }
}
