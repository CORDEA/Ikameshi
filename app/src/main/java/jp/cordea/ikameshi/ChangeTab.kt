package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor

class ChangeTab {
    private val _reader = PublishProcessor.create<MainScreen.Tab>()
    val reader: Flowable<Action> = _reader.map { Action.ChangeTab(it) }

    fun dispatch(tab: MainScreen.Tab) {
        _reader.offer(tab)
    }
}
