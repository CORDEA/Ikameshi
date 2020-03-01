package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.compose.onDispose
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.LayoutHeight
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.SerialDisposable
import io.reactivex.rxkotlin.subscribeBy

class FavoriteScreen(
    private val actions: Actions,
    private val store: MusicStore,
    private val listItem: MusicListItem
) {
    private val serialDisposable = SerialDisposable()

    @Composable
    fun View(state: FavoriteState) {
        onActive {
            store.onFavoriteMusicChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy { result ->
                    when (result) {
                        MusicResult.FetchFavoriteMusics.Loading -> {
                        }
                        is MusicResult.FetchFavoriteMusics.Success ->
                            state.items = result.musics.map {
                                MusicItemState(
                                    it.id,
                                    it.title,
                                    it.liked
                                )
                            }
                        MusicResult.FetchFavoriteMusics.Failure ->
                            state.items = emptyList()
                    }
                }
                .run { serialDisposable.set(this) }
            actions.fetchFavoriteMusics()
        }
        onDispose {
            serialDisposable.dispose()
        }
        VerticalScroller(modifier = LayoutHeight.Fill) {
            state.items.forEach { listItem.View(it) }
        }
    }
}
