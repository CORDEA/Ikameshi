package jp.cordea.ikameshi

import androidx.compose.Model

@Model
data class LikeState(
    var items: List<LikeItemState> = emptyList()
)

@Model
data class LikeItemState(
    val id: Long,
    val title: String
)
