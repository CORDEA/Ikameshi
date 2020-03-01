package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType

class MusicStore(
    dispatcher: Dispatcher,
    private val repository: MusicRepository
) {
    private val fetchMusicsEvent =
        dispatcher.reader.ofType<Action.FetchMusics>().share()
    private val fetchMusics: Flowable<MusicResult> =
        fetchMusicsEvent
            .flatMap { repository.findAll().toFlowable() }
            .map<MusicResult> { MusicResult.FetchMusics.Success(it) }
            .onErrorReturnItem(MusicResult.FetchMusics.Failure)

    fun onResult(): Flowable<MusicResult> =
        Flowable
            .merge(
                fetchMusicsEvent.map { MusicResult.FetchMusics.Loading },
                fetchMusics
            )
            .share()
}
