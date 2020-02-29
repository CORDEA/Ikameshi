package jp.cordea.ikameshi

sealed class Action {
    class ChangeTab(val tab: Tab) : Action()
    class FetchMusics(val musics: List<Music>) : Action()
}
