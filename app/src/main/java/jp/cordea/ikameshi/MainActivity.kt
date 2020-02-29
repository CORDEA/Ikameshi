package jp.cordea.ikameshi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.tooling.preview.Preview
import org.koin.android.scope.currentScope

class MainActivity : AppCompatActivity() {
    private val store by currentScope.inject<MainStore>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { store.provide { View(it) } }
    }

    override fun onDestroy() {
        super.onDestroy()
        store.dispose()
    }
}

enum class MainTab(val title: String) {
    ALBUM("Album"),
    MUSIC("Music"),
    LIKE("Like")
}

@Composable
fun View(state: MainState) {
    MaterialTheme {
        Column {
            Container(modifier = LayoutFlexible(1f)) {
                when (state.tab) {
                    MainTab.ALBUM -> AlbumScreen.View()
                    MainTab.MUSIC -> MusicScreen.View()
                    MainTab.LIKE -> LikeScreen.View()
                }
            }
            PlayerScreen.Collapsed()
            TabRow(items = MainTab.values().asList(), selectedIndex = 0, tab = { index, tab ->
                Tab(
                    text = tab.title,
                    selected = tab.ordinal == index,
                    onSelected = {
                    }
                )
            }, indicatorContainer = {})
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    View(MainState())
}
