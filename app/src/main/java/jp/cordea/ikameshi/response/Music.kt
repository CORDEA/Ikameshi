package jp.cordea.ikameshi.response

class Music(
    val id: Long,
    val title: String,
    val artist: Artist,
    val thumbnailUrl: String,
    val releaseYear: String,
    val liked: Boolean
)
