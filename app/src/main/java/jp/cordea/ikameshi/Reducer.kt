package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers

class Reducer(
    private val changeTab: ChangeTab,
    private val fetchMusics: FetchMusics
) {
    fun reduce(initialState: State): Flowable<State> =
        Flowable.merge(fetchMusics.reader, changeTab.reader)
            .distinctUntilChanged()
            .observeOn(AndroidSchedulers.mainThread())
            .scanWith({ initialState }, { state, action ->
                when (action) {
                    is Action.ChangeTab ->
                        State(state.mainState.copy(tab = action.tab))
                    is Action.FetchMusics ->
                        State(state.mainState.copy(
                            music = MusicState(
                                action.musics.map {
                                    MusicItemState(
                                        it.id,
                                        it.title
                                    )
                                }
                            )
                        ))
                }
            })
}
