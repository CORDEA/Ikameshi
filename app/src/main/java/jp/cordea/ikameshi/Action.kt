package jp.cordea.ikameshi

sealed class Action {
    class FetchMusics(val musics: List<Music>) : Action()
}
