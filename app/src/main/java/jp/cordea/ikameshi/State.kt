package jp.cordea.ikameshi

import androidx.compose.Model
import jp.cordea.ikameshi.screen.MainState

@Model
data class State(var mainState: MainState = MainState())
