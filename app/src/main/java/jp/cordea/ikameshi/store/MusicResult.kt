package jp.cordea.ikameshi.store

import jp.cordea.ikameshi.response.Music

sealed class MusicResult {
    sealed class FetchMusics : MusicResult() {
        object Loading : FetchMusics()
        class Success(val musics: List<Music>) : FetchMusics()
        object Failure : FetchMusics()
    }

    sealed class FetchFavoriteMusics : MusicResult() {
        object Loading : FetchFavoriteMusics()
        class Success(val musics: List<Music>) : FetchFavoriteMusics()
        object Failure : FetchFavoriteMusics()
    }

    sealed class ChangeFavoriteState(val id: Long) : MusicResult() {
        class Loading(id: Long) : ChangeFavoriteState(id)
        class Like(id: Long) : ChangeFavoriteState(id)
        class Unlike(id: Long) : ChangeFavoriteState(id)
        class Failure(id: Long) : ChangeFavoriteState(id)
    }
}
