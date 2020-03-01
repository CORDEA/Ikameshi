package jp.cordea.ikameshi

sealed class TabResult {
    class Select(val tab: MainScreen.Tab) : TabResult()
}
