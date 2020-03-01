package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers

class Reducer(
    private val changeTab: ChangeTab,
    private val likeMusic: LikeMusic,
    private val unlikeMusic: UnlikeMusic,
    private val fetchMusics: FetchMusics
) {
    fun reduce(initialState: State): Flowable<State> =
        Flowable.merge(fetchMusics.reader, changeTab.reader, likeMusic.reader, unlikeMusic.reader)
            .distinctUntilChanged()
            .observeOn(AndroidSchedulers.mainThread())
            .scanWith({ initialState }, { state, action ->
                when (action) {
                    is Action.ChangeTab ->
                        State(state.mainState.copy(tab = action.tab))
                    is Action.FetchMusics -> state
//                        State(state.mainState.copy(
//                            music = MusicState(
//                                action.musics.map {
//                                    MusicItemState(
//                                        it.id,
//                                        it.title
//                                    )
//                                }
//                            )
//                        ))
                    is Action.LikeMusic -> state
                    is Action.UnlikeMusic -> state
                }
            })
}
