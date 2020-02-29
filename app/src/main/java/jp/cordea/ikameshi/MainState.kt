package jp.cordea.ikameshi

import androidx.compose.Model

@Model
class MainState(
    var tab: MainTab = MainTab.ALBUM,
    var music: MusicState = MusicState()
)
