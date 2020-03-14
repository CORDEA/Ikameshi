package jp.cordea.ikameshi.store

import jp.cordea.ikameshi.response.Music

sealed class MusicPlaybackResult {
    class Play(val music: Music) : MusicPlaybackResult()
    object Pause : MusicPlaybackResult()
}
