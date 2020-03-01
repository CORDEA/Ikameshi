package jp.cordea.ikameshi

import androidx.compose.Model

@Model
data class MusicState(
    val items: List<MusicItemState> = emptyList()
)

@Model
data class MusicItemState(
    val id: Long,
    val title: String
)
