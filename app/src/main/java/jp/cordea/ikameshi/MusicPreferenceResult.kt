package jp.cordea.ikameshi

sealed class MusicPreferenceResult(val id: Long) {
    class Loading(id: Long) : MusicPreferenceResult(id)
    class Like(id: Long) : MusicPreferenceResult(id)
    class Unlike(id: Long) : MusicPreferenceResult(id)
    class Failure(id: Long) : MusicPreferenceResult(id)
}
