package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.LayoutAlign

object LikeScreen {
    @Composable
    fun View() {
        Text(modifier = LayoutAlign.Center, text = "like")
    }
}
