package jp.cordea.ikameshi

class Actions(
    private val fetchMusics: FetchMusics
) {
    fun fetchMusics() = fetchMusics.dispatch()
}
