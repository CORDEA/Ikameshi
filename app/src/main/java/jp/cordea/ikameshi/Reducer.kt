package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class Reducer(
    private val fetchMusics: FetchMusics
) {
    fun reduce(): Flowable<MainState> =
        fetchMusics.reader
            .map { MainState() }
            .subscribeOn(Schedulers.io())
}
