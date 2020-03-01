package jp.cordea.ikameshi

import org.koin.dsl.module

val storeModule = module {
    single { MusicStore(get(), get()) }
    single { TabStore(get()) }
    single { MusicPreferenceStore(get(), get()) }
}
