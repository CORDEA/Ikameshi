package jp.cordea.ikameshi.action

import jp.cordea.ikameshi.screen.MainScreen

sealed class Action {
    class ChangeTab(val tab: MainScreen.Tab) : Action()
    class FetchMusics : Action()
    object FetchFavoriteMusics : Action()
    class LikeMusic(val id: Long) : Action()
    class UnlikeMusic(val id: Long) : Action()
    class PlayMusic(val id: Long) : Action()
    object PauseMusic : Action()
    class PlayNextMusic(val id: Long) : Action()
    class PlayPreviousMusic(val id: Long) : Action()
}
