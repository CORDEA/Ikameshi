package jp.cordea.ikameshi

import androidx.compose.Model

@Model
class MusicState(
    var items: List<MusicItemState> = emptyList()
)

@Model
class MusicItemState(
    val id: Long,
    val title: String
)
