package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp

object AlbumScreen {
    @Composable
    fun Item(state: AlbumItemState) {
        Ripple(bounded = true) {
            Clickable(onClick = {}) {
                Card(modifier = LayoutPadding(16.dp), shape = RoundedCornerShape(12.dp)) {
                    Container {
                        Column {
                            Surface(color = Color.Blue) {
                                Container(modifier = LayoutAspectRatio(1.7f)) {
                                }
                            }
                            Spacer(modifier = LayoutHeight(16.dp))
                            Text(
                                text = "Album",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = LayoutPadding(left = 16.dp, right = 16.dp)
                            )
                            Text(
                                text = "Description",
                                style = TextStyle(fontSize = 16.sp),
                                modifier = LayoutPadding(
                                    top = 4.dp,
                                    right = 16.dp,
                                    bottom = 16.dp,
                                    left = 16.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun View(state: AlbumState) {
        VerticalScroller(modifier = LayoutHeight.Fill) {
            state.items.forEach {
                Item(it)
            }
        }
    }
}
