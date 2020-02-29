package jp.cordea.ikameshi

class Actions(
    private val changeTab: ChangeTab,
    private val fetchMusics: FetchMusics
) {
    fun changeTab(tab: Tab) = changeTab.dispatch(tab)
    fun fetchMusics() = fetchMusics.dispatch()
}
