package jp.cordea.ikameshi

import androidx.compose.Composable
import androidx.compose.onActive
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

class Store(
    private val reducer: Reducer
) {
    private var state = State()
    private lateinit var disposable: Disposable

    @Composable
    fun provide(view: @Composable() (State) -> Unit) {
        onActive {
//            disposable = reducer.reduce(state)
//                .subscribeBy { state.mainState = it.mainState }
        }
        view(state)
    }

    fun dispose() {
        disposable.dispose()
    }
}
