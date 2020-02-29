package jp.cordea.ikameshi

import androidx.compose.Composable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

class Store(
    private val reducer: Reducer
) {
    private val state = State()
    private lateinit var disposable: Disposable

    @Composable
    fun provide(view: @Composable() (State) -> Unit) {
        view(state)
        disposable = reducer.reduce()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy {
            }
    }

    fun dispose() {
        disposable.dispose()
    }
}
