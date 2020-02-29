package jp.cordea.ikameshi

import androidx.compose.Composable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

class MainStore(
    private val reducer: Reducer
) {
    private val state = MainState()
    private lateinit var disposable: Disposable

    fun provide(view: @Composable() (MainState) -> Unit) {
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
