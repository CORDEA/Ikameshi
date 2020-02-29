package jp.cordea.ikameshi

import androidx.compose.Composable

class Store(
    private val reducer: Reducer
) {
    fun provide(view: @Composable() () -> Unit) {
        view()
    }
}
