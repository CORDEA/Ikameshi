package jp.cordea.ikameshi

sealed class MusicResult {
    sealed class FetchMusics : MusicResult() {
        object Loading : FetchMusics()
        class Success(val musics: List<Music>) : FetchMusics()
        object Failure : FetchMusics()
    }
}
