package jp.cordea.ikameshi

import androidx.compose.Model

@Model
data class MainState(
    var tab: Tab = Tab.ALBUM,
    var player: PlayerState = PlayerState(),
    var music: MusicState = MusicState(),
    var album: AlbumState = AlbumState(),
    var like: LikeState = LikeState()
)
