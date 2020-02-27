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

class MainActivity : AppCompatActivity() {
    private var state = MainState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { View(state) }
    }
}

enum class MainTab(val title: String) {
    HOME("Home"),
    DRAFT("Draft"),
    LIKE("Like")
}

@Composable
fun View(state: MainState) {
    MaterialTheme {
        Column {
            Container(modifier = LayoutFlexible(1f)) {
                when (state.tab) {
                    MainTab.HOME -> HomeScreen.View()
                    MainTab.DRAFT -> DraftScreen.View()
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
