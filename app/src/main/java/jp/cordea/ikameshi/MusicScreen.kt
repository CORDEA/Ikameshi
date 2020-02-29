package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.LayoutHeight

object MusicScreen {
    @Composable
    fun View(state: MusicState) {
        VerticalScroller(modifier = LayoutHeight.Fill) {
            state.items.forEach {
                MusicListItem()
            }
        }
    }
}
