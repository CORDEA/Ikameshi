package jp.cordea.ikameshi.store

import jp.cordea.ikameshi.screen.MainScreen

sealed class TabResult {
    class Select(val tab: MainScreen.Tab) : TabResult()
}
