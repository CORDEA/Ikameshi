package jp.cordea.ikameshi.screen

import androidx.compose.Model

@Model
data class FavoriteState(
    var items: List<MusicItemState> = emptyList()
)
