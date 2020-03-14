package jp.cordea.ikameshi

import io.reactivex.Flowable
import io.reactivex.rxkotlin.ofType
import jp.cordea.ikameshi.action.Action
import jp.cordea.ikameshi.repository.MusicRepository

class MusicPlaybackStore(
    private val dispatcher: Dispatcher,
    private val repository: MusicRepository
) {
    fun onMusicPlaybackStateChanged() =
        Flowable.merge(
            dispatcher.reader.ofType<Action.PlayMusic>()
                .flatMap { repository.find(it.id).toFlowable() }
                .map { MusicPlaybackResult.Play(it) },
            dispatcher.reader.ofType<Action.PauseMusic>()
                .map { MusicPlaybackResult.Pause },
            dispatcher.reader.ofType<Action.PlayNextMusic>()
                .flatMap { repository.find(it.id).toFlowable() }
                .map { MusicPlaybackResult.Play(it) },
            dispatcher.reader.ofType<Action.PlayPreviousMusic>()
                .flatMap { repository.find(it.id).toFlowable() }
                .map { MusicPlaybackResult.Play(it) }
        )
}
