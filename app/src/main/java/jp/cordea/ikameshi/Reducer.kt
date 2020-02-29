package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class Reducer(
    private val changeTab: ChangeTab,
    private val fetchMusics: FetchMusics
) {
    fun reduce(): Flowable<MainState> =
        Flowable.merge(fetchMusics.reader, changeTab.reader)
            .map { MainState() }
            .subscribeOn(Schedulers.io())
}
