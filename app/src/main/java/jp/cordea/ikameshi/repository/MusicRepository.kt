package jp.cordea.ikameshi.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import jp.cordea.ikameshi.response.Artist
import jp.cordea.ikameshi.response.Music
import java.util.concurrent.TimeUnit

class MusicRepository {
    fun findAll(): Single<List<Music>> =
        Single
            .just(
                listOf(
                    Music(
                        0L,
                        "music",
                        Artist(0L, "artist"),
                        "",
                        "",
                        false
                    )
                )
            )
            .delay(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
}
