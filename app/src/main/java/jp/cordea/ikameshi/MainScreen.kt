package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.Tab
import androidx.ui.material.TabRow

object MainScreen {
    @Composable
    fun View(state: MainState) {
        Column {
            Container(modifier = LayoutFlexible(1f)) {
                when (state.tab) {
                    Tab.ALBUM -> AlbumScreen.View(state.album)
                    Tab.MUSIC -> MusicScreen.View(state.music)
                    Tab.LIKE -> LikeScreen.View(state.like)
                }
            }
            PlayerScreen.Collapsed(state.player)
            TabRow(items = Tab.values().asList(), selectedIndex = 0, tab = { index, tab ->
                Tab(
                    text = tab.title,
                    selected = tab.ordinal == index,
                    onSelected = {
                    }
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
