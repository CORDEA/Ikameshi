package jp.cordea.ikameshi

import androidx.compose.Model

@Model
data class MainState(
    val tab: Tab = Tab.ALBUM,
    val player: PlayerState = PlayerState(),
    val music: MusicState = MusicState(),
    val album: AlbumState = AlbumState(),
    val like: LikeState = LikeState()
)
