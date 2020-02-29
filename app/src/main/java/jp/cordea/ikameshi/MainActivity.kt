package jp.cordea.ikameshi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import org.koin.android.scope.currentScope

class MainActivity : AppCompatActivity() {
    private val store by currentScope.inject<Store>()
    private val actions by currentScope.inject<Actions>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { store.provide { View(it) } }
    }

    override fun onDestroy() {
        super.onDestroy()
        store.dispose()
    }
}

@Composable
fun View(state: State) {
    MaterialTheme {
        MainScreen.View(state.mainState)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    View(State())
}
