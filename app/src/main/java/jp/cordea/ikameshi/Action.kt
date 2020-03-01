package jp.cordea.ikameshi

sealed class Action {
    class ChangeTab(val tab: Tab) : Action()
    class FetchMusics() : Action()
    class LikeMusic(val id: Long) : Action()
    class UnlikeMusic(val id: Long) : Action()
}
