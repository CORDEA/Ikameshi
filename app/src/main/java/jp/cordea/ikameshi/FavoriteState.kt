package jp.cordea.ikameshi

import androidx.compose.Model

@Model
data class FavoriteState(
    var items: List<MusicItemState> = emptyList()
)
