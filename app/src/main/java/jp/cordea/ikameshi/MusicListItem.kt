package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun Actions.MusicListItem(state: MusicItemState) {
    Ripple(bounded = true) {
        Clickable(onClick = {}) {
            Container(padding = EdgeInsets(16.dp)) {
                Row(modifier = LayoutWidth.Fill) {
                    Surface(color = Color.Blue, shape = RoundedCornerShape(2.dp)) {
                        Container(height = 56.dp, width = 56.dp) {
                        }
                    }
                    Column(modifier = LayoutPadding(left = 16.dp) + LayoutFlexible(1f) + LayoutGravity.Center) {
                        Text(
                            text = "Music",
                            style = TextStyle(fontSize = 16.sp)
                        )
                        Spacer(modifier = LayoutHeight(2.dp))
                        Text(
                            text = "Caption",
                            style = TextStyle(fontSize = 12.sp)
                        )
                    }
                    Ripple(bounded = false) {
                        Clickable(onClick = {
                        }) {
                            Container(
                                modifier = LayoutGravity.Center,
                                padding = EdgeInsets(16.dp)
                            ) {
                                DrawVector(vectorResource(R.drawable.ic_baseline_favorite_border_24))
                            }
                        }
                    }
                    Spacer(modifier = LayoutWidth(16.dp))
                    Container(modifier = LayoutGravity.Center, padding = EdgeInsets(16.dp)) {
                        DrawVector(vectorResource(R.drawable.ic_baseline_play_circle_outline_24))
                    }
                }
            }
        }
    }
}
