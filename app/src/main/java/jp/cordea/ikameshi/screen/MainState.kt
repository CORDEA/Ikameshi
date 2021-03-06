package jp.cordea.ikameshi.screen

import androidx.compose.Model

@Model
data class MainState(
    var tab: MainScreen.Tab = MainScreen.Tab.ALBUM,
    val player: PlayerState = PlayerState(),
    val music: MusicState = MusicState(),
    val album: AlbumState = AlbumState(),
    val favorite: FavoriteState = FavoriteState()
)
