package jp.cordea.ikameshi

import io.reactivex.Completable
import java.util.concurrent.TimeUnit

class MusicPreferenceRepository {
    fun like(): Completable = Completable.complete().delay(1000, TimeUnit.MILLISECONDS)
    fun unlike(): Completable = Completable.complete().delay(1000, TimeUnit.MILLISECONDS)
}
