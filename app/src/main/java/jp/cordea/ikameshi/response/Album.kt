package jp.cordea.ikameshi.response

class Album(
    val id: Long,
    val title: String,
    val artist: Artist,
    val thumbnailUrl: String,
    val releaseYear: String
)
