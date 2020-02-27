package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp

object AlbumScreen {
    @Composable
    fun Item() {
        Ripple(bounded = true) {
            Clickable(onClick = {}) {
                Container(padding = EdgeInsets(16.dp)) {
                    Row(arrangement = Arrangement.Center) {
                        Text(
                            text = "",
                            modifier = LayoutGravity.Center + LayoutPadding(right = 16.dp)
                        )
                        Column {
                            Text(
                                text = "",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "",
                                style = TextStyle(fontSize = 12.sp),
                                modifier = LayoutPadding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun View() {
        VerticalScroller {
        }
    }
}
