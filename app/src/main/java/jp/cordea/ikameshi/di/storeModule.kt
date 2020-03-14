package jp.cordea.ikameshi.di

import jp.cordea.ikameshi.store.MusicStore
import jp.cordea.ikameshi.store.TabStore
import org.koin.dsl.module

val storeModule = module {
    single { MusicStore(get(), get(), get()) }
    single { TabStore(get()) }
}
