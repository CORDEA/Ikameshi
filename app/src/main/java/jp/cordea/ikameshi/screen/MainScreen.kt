package jp.cordea.ikameshi.screen

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.compose.onDispose
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.material.TopAppBar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.SerialDisposable
import io.reactivex.rxkotlin.subscribeBy
import jp.cordea.ikameshi.action.Actions
import jp.cordea.ikameshi.store.TabResult
import jp.cordea.ikameshi.store.TabStore

class MainScreen(
    private val actions: Actions,
    private val store: TabStore,
    private val musicScreen: MusicScreen,
    private val favoriteScreen: FavoriteScreen
) {
    private val serialDisposable = SerialDisposable()

    @Composable
    fun View(state: MainState) {
        onActive {
            store.onResult()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    when (it) {
                        is TabResult.Select -> state.tab = it.tab
                    }
                }
                .run { serialDisposable.set(this) }
        }
        onDispose {
            serialDisposable.dispose()
        }
        Column {
            TopAppBar(
                title = {
                    Text(state.tab.title)
                }
            )
            Container(modifier = LayoutFlexible(1f)) {
                when (state.tab) {
                    Tab.ALBUM -> AlbumScreen.View(state.album)
                    Tab.MUSIC -> musicScreen.View(state.music)
                    Tab.LIKE -> favoriteScreen.View(state.favorite)
                }
            }
            PlayerScreen.Collapsed(state.player)
            TabRow(items = Tab.values().asList(), selectedIndex = 0, tab = { index, tab ->
                Tab(
                    text = tab.title,
                    selected = tab.ordinal == index,
                    onSelected = { actions.changeTab(tab) }
                )
            }, indicatorContainer = {})
        }
    }

    enum class Tab(val title: String) {
        ALBUM("Album"),
        MUSIC("Music"),
        LIKE("Like")
    }
}
