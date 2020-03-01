package jp.cordea.ikameshi

class Actions(
    private val changeTab: ChangeTab,
    private val likeMusic: LikeMusic,
    private val fetchMusics: FetchMusics,
    private val unlikeMusic: UnlikeMusic
) {
    fun changeTab(tab: Tab) = changeTab.dispatch(tab)
    fun fetchMusics() = fetchMusics.dispatch()
    fun likeMusic(id: Long) = likeMusic.dispatch(id)
    fun unlikeMusic(id: Long) = unlikeMusic.dispatch(id)
}
