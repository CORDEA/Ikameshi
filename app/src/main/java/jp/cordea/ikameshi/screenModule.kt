package jp.cordea.ikameshi

import jp.cordea.ikameshi.screen.FavoriteScreen
import jp.cordea.ikameshi.screen.MainScreen
import jp.cordea.ikameshi.screen.MusicScreen
import org.koin.dsl.module

val screenModule = module {
    factory { MainScreen(get(), get(), get(), get()) }
    factory { MusicScreen(get(), get(), get()) }
    factory { FavoriteScreen(get(), get(), get()) }
    factory { MusicListItem(get(), get()) }
}
