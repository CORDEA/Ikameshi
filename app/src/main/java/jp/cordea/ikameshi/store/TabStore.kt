package jp.cordea.ikameshi.store

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType
import jp.cordea.ikameshi.Dispatcher
import jp.cordea.ikameshi.action.Action

class TabStore(
    private val dispatcher: Dispatcher
) {
    fun onResult(): Flowable<TabResult> =
        dispatcher.reader
            .ofType<Action.ChangeTab>()
            .map { TabResult.Select(it.tab) }
}
