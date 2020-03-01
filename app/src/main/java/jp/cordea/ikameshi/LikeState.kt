package jp.cordea.ikameshi

import androidx.compose.Model

@Model
data class LikeState(
    var items: List<MusicItemState> = emptyList()
)
