package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType

class TabStore(
    private val dispatcher: Dispatcher
) {
    fun onResult(): Flowable<TabResult> =
        dispatcher.reader
            .ofType<Action.ChangeTab>()
            .map { TabResult.Select(it.tab) }
}
