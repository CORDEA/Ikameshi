package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.LayoutHeight

class LikeScreen(
    private val listItem: MusicListItem
) {
    @Composable
    fun View(state: LikeState) {
        VerticalScroller(modifier = LayoutHeight.Fill) {
            state.items.forEach { listItem.View(it) }
        }
    }
}
