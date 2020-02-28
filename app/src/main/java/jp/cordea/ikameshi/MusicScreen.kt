package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.LayoutHeight

object MusicScreen {
    @Composable
    fun View() {
        VerticalScroller(modifier = LayoutHeight.Fill) {
            MusicListItem()
        }
    }
}
