package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType

class TabStore(
    private val dispatcher: Dispatcher
) {
    fun onResult(): Flowable<TabResult> =
        dispatcher.reader
            .ofType<Action.ChangeTab>()
            .map {
                when (it.tab) {
                    Tab.ALBUM -> TabResult.SelectAlbum
                    Tab.MUSIC -> TabResult.SelectMusic
                    Tab.LIKE -> TabResult.SelectLike
                }
            }
}
