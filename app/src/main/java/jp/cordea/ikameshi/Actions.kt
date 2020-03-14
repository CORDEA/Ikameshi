package jp.cordea.ikameshi

import jp.cordea.ikameshi.screen.MainScreen

class Actions(private val dispatcher: Dispatcher) {
    fun changeTab(tab: MainScreen.Tab) = dispatcher.dispatch(Action.ChangeTab(tab))
    fun fetchMusics() = dispatcher.dispatch(Action.FetchMusics())
    fun fetchFavoriteMusics() = dispatcher.dispatch(Action.FetchFavoriteMusics)
    fun likeMusic(id: Long) = dispatcher.dispatch(Action.LikeMusic(id))
    fun unlikeMusic(id: Long) = dispatcher.dispatch(Action.UnlikeMusic(id))
}
