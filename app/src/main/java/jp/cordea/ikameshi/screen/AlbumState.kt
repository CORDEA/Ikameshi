package jp.cordea.ikameshi.screen

import androidx.compose.Model

@Model
data class AlbumState(
    var items: List<AlbumItemState> = emptyList()
)

@Model
data class AlbumItemState(
    val id: Long,
    val title: String
)
