package jp.cordea.ikameshi.screen

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.surface.Surface
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import jp.cordea.ikameshi.R

object PlayerScreen {
    @Composable
    fun Expanded(state: PlayerState) {
    }

    @Composable
    fun Collapsed(state: PlayerState) {
        Surface(color = Color.Green) {
            Row(modifier = LayoutWidth.Fill) {
                Container(
                    padding = EdgeInsets(
                        left = 36.dp,
                        top = 16.dp,
                        right = 16.dp,
                        bottom = 16.dp
                    ), modifier = LayoutGravity.Center
                ) {
                    DrawVector(vectorResource(R.drawable.ic_baseline_fast_rewind_24))
                }
                Column(modifier = LayoutFlexible(1f) + LayoutPadding(8.dp)) {
                    Text("")
                    Spacer(modifier = LayoutHeight(4.dp))
                    Text("")
                }
                Container(padding = EdgeInsets(16.dp), modifier = LayoutGravity.Center) {
                    DrawVector(vectorResource(R.drawable.ic_baseline_pause_24))
                }
                Spacer(modifier = LayoutHeight(8.dp))
                Container(
                    padding = EdgeInsets(
                        left = 36.dp,
                        top = 16.dp,
                        right = 16.dp,
                        bottom = 16.dp
                    ), modifier = LayoutGravity.Center
                ) {
                    DrawVector(vectorResource(R.drawable.ic_baseline_fast_forward_24))
                }
            }
        }
    }
}
