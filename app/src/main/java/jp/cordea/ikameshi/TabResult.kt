package jp.cordea.ikameshi

sealed class TabResult {
    object SelectAlbum : TabResult()
    object SelectMusic : TabResult()
    object SelectLike : TabResult()
}
