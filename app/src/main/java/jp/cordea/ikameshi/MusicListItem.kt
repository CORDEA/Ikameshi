package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.compose.onDispose
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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.SerialDisposable
import io.reactivex.rxkotlin.subscribeBy
import jp.cordea.ikameshi.screen.MusicItemState

class MusicListItem(
    private val actions: Actions,
    private val store: MusicStore
) {
    private val serialDisposable = SerialDisposable()

    @Composable
    fun View(state: MusicItemState) {
        onActive {
            store.onFavoriteStateChanged()
                .filter { it.id == state.id }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    when (it) {
                        is MusicResult.ChangeFavoriteState.Loading -> {
                        }
                        is MusicResult.ChangeFavoriteState.Like ->
                            state.liked = true
                        is MusicResult.ChangeFavoriteState.Unlike ->
                            state.liked = false
                        is MusicResult.ChangeFavoriteState.Failure -> {
                        }
                    }
                }
                .run { serialDisposable.set(this) }
        }
        onDispose {
            serialDisposable.dispose()
        }
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
                                if (state.liked) {
                                    actions.unlikeMusic(state.id)
                                } else {
                                    actions.likeMusic(state.id)
                                }
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
}
