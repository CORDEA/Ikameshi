package jp.cordea.ikameshi.screen

import androidx.compose.Model
import jp.cordea.ikameshi.screen.MusicItemState

@Model
data class FavoriteState(
    var items: List<MusicItemState> = emptyList()
)
