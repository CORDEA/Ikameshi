package jp.cordea.ikameshi.screen

import androidx.compose.Model

@Model
data class MusicState(
    var items: List<MusicItemState> = emptyList()
)

@Model
data class MusicItemState(
    val id: Long,
    val title: String,
    var liked: Boolean = false
)
