package jp.cordea.ikameshi

import io.reactivex.Single
import java.util.concurrent.TimeUnit

class MusicRepository {
    fun findAll(): Single<List<Music>> =
        Single.just(listOf(
            Music(0L, "music", Artist(0L, "artist"), "", "")
        )).delay(1, TimeUnit.SECONDS)
}
