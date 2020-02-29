package jp.cordea.ikameshi

sealed class Action {
    class ChangeTab(val tab: MainScreen.Tab) : Action()
    class FetchMusics(val musics: List<Music>) : Action()
}
