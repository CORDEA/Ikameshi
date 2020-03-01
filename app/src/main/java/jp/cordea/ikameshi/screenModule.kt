package jp.cordea.ikameshi

import org.koin.dsl.module

val screenModule = module {
    factory { MainScreen(get(), get(), get(), get()) }
    factory { MusicScreen(get(), get(), get()) }
    factory { FavoriteScreen(get()) }
    factory { MusicListItem(get(), get()) }
}
