package jp.cordea.ikameshi.screen

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.compose.onDispose
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.LayoutHeight
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.SerialDisposable
import io.reactivex.rxkotlin.subscribeBy
import jp.cordea.ikameshi.*

class MusicScreen(
    private val actions: Actions,
    private val store: MusicStore,
    private val listItem: MusicListItem
) {
    private val serialDisposable = SerialDisposable()

    @Composable
    fun View(state: MusicState) {
        onActive {
            store.onMusicChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    when (it) {
                        MusicResult.FetchMusics.Loading -> {
                        }
                        is MusicResult.FetchMusics.Success ->
                            state.items = it.musics.map { music ->
                                MusicItemState(
                                    music.id,
                                    music.title
                                )
                            }
                        MusicResult.FetchMusics.Failure ->
                            state.items = emptyList()
                    }
                }
                .run { serialDisposable.set(this) }
            actions.fetchMusics()
        }
        onDispose {
            serialDisposable.dispose()
        }
        VerticalScroller(modifier = LayoutHeight.Fill) {
            state.items.forEach { listItem.View(it) }
        }
    }
}
