package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.LayoutHeight

class MusicScreen(
    private val actions: Actions,
    private val store: MusicStore
) {
    @Composable
    fun View(state: MusicState) {
        VerticalScroller(modifier = LayoutHeight.Fill) {
            state.items.forEach {
                //                MusicListItem(it)
            }
        }
    }
}
