package jp.cordea.ikameshi

import androidx.compose.Model

@Model
class MainState(
    var tab: MainScreen.Tab = MainScreen.Tab.ALBUM,
    var music: MusicState = MusicState()
)
