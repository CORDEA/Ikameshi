package jp.cordea.ikameshi

import org.koin.dsl.module

val storeModule = module {
    single { MusicStore(get(), get(), get()) }
    single { MusicPlaybackStore(get(), get()) }
    single { TabStore(get()) }
}
