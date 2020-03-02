package jp.cordea.ikameshi

sealed class MusicPlaybackResult {
    class Play(val music: Music) : MusicPlaybackResult()
    object Pause : MusicPlaybackResult()
}
