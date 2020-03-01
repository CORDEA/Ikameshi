package jp.cordea.ikameshi

sealed class LikeMusicResult(val id: Long) {
    class Loading(id: Long) : LikeMusicResult(id)
    class Like(id: Long) : LikeMusicResult(id)
    class Unlike(id: Long) : LikeMusicResult(id)
    class Failure(id: Long) : LikeMusicResult(id)
}
