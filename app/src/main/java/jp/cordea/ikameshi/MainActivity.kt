package jp.cordea.ikameshi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val mainScreen by inject<MainScreen>()
    private val state = State()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { View(state) }
    }

    @Composable
    fun View(state: State) {
        MaterialTheme {
            mainScreen.View(state.mainState)
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        View(State())
    }
}
