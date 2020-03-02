package jp.cordea.ikameshi

class Actions(private val dispatcher: Dispatcher) {
    fun changeTab(tab: MainScreen.Tab) = dispatcher.dispatch(Action.ChangeTab(tab))
    fun fetchMusics() = dispatcher.dispatch(Action.FetchMusics())
    fun fetchFavoriteMusics() = dispatcher.dispatch(Action.FetchFavoriteMusics)
    fun likeMusic(id: Long) = dispatcher.dispatch(Action.LikeMusic(id))
    fun unlikeMusic(id: Long) = dispatcher.dispatch(Action.UnlikeMusic(id))
    fun playMusic(id: Long) = dispatcher.dispatch(Action.PlayMusic(id))
    fun playNextMusic(id: Long) = dispatcher.dispatch(Action.PlayNextMusic(id))
    fun playPreviousMusic(id: Long) = dispatcher.dispatch(Action.PlayPreviousMusic(id))
    fun pauseMusic() = dispatcher.dispatch(Action.PauseMusic)
}
