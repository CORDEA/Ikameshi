package jp.cordea.ikameshi.response

import jp.cordea.ikameshi.response.Artist

class Album(
    val id: Long,
    val title: String,
    val artist: Artist,
    val thumbnailUrl: String,
    val releaseYear: String
)
