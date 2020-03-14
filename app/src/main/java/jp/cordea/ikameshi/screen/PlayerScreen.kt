package jp.cordea.ikameshi.screen

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.compose.onDispose
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.SerialDisposable
import io.reactivex.rxkotlin.subscribeBy
import jp.cordea.ikameshi.MusicPlaybackResult
import jp.cordea.ikameshi.MusicPlaybackStore
import jp.cordea.ikameshi.R
import jp.cordea.ikameshi.action.Actions

class PlayerScreen(
    private val actions: Actions,
    private val store: MusicPlaybackStore
) {
    private val serialDisposable = SerialDisposable()

    @Composable
    fun Expanded(state: PlayerState) {
        onActive {
            store.onMusicPlaybackStateChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {

                }
                .run { serialDisposable.set(this) }

        }
        onDispose {
            serialDisposable.dispose()
        }
    }

    @Composable
    fun Collapsed(state: PlayerState) {
        onActive {
            store.onMusicPlaybackStateChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    when (it) {
                        is MusicPlaybackResult.Play -> {
                            state.playing = true
                            state.id = it.music.id
                            state.title = it.music.title
                        }
                        MusicPlaybackResult.Pause ->
                            state.playing = false
                    }
                }
                .run { serialDisposable.set(this) }

        }
        onDispose {
            serialDisposable.dispose()
        }
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
                Ripple(bounded = false) {
                    Clickable(onClick = {
                        if (state.playing) {
                            actions.pauseMusic()
                        } else {
                            actions.playMusic(state.id)
                        }
                    }) {
                        if (state.playing) {
                            Container(
                                padding = EdgeInsets(16.dp),
                                modifier = LayoutGravity.Center
                            ) {
                                DrawVector(vectorResource(R.drawable.ic_baseline_pause_24))
                            }
                        } else {
                            Container(
                                padding = EdgeInsets(16.dp),
                                modifier = LayoutGravity.Center
                            ) {
                                DrawVector(vectorResource(R.drawable.ic_baseline_play_arrow_24))
                            }
                        }
                    }
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
