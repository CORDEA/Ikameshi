package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.LayoutHeight
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy

class MusicScreen(
    private val actions: Actions,
    private val store: MusicStore
) {
    @Composable
    fun View(state: MusicState) {
        onActive {
            store.onResult()
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
            actions.fetchMusics()
        }
        VerticalScroller(modifier = LayoutHeight.Fill) {
            state.items.forEach {
                //                MusicListItem(it)
            }
        }
    }
}
