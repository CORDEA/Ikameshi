package jp.cordea.ikameshi

import androidx.compose.Model

@Model
data class PlayerState(
    var id: Long = 0L,
    var title: String = "",
    var playing: Boolean = false
)
