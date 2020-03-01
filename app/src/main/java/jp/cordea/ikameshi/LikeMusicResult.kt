package jp.cordea.ikameshi

sealed class LikeMusicResult {
    class Loading(val id: Long) : LikeMusicResult()
    class Like(val id: Long) : LikeMusicResult()
    class Unlike(val id: Long) : LikeMusicResult()
    class Failure(val id: Long) : LikeMusicResult()
}
