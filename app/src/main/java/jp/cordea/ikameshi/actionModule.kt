package jp.cordea.ikameshi

import org.koin.dsl.module

val actionModule = module {
    single { Actions(get()) }
    single { ChangeTab() }
    single { FetchMusics(get()) }
    single { LikeMusic(get()) }
    single { UnlikeMusic(get()) }
}
