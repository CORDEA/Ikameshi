package jp.cordea.ikameshi

class Actions(
    private val dispatcher: Dispatcher,
    private val likeMusic: LikeMusic,
    private val unlikeMusic: UnlikeMusic
) {
    fun changeTab(tab: MainScreen.Tab) = dispatcher.dispatch(Action.ChangeTab(tab))
    fun fetchMusics() = dispatcher.dispatch(Action.FetchMusics())
    fun likeMusic(id: Long) = likeMusic.dispatch(id)
    fun unlikeMusic(id: Long) = unlikeMusic.dispatch(id)
}
