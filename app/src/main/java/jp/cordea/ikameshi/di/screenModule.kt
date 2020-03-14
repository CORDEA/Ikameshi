package jp.cordea.ikameshi.di

import jp.cordea.ikameshi.MusicListItem
import jp.cordea.ikameshi.screen.FavoriteScreen
import jp.cordea.ikameshi.screen.MainScreen
import jp.cordea.ikameshi.screen.MusicScreen
import jp.cordea.ikameshi.screen.PlayerScreen
import org.koin.dsl.module

val screenModule = module {
    factory { MainScreen(get(), get(), get(), get(), get()) }
    factory { MusicScreen(get(), get(), get()) }
    factory { FavoriteScreen(get(), get(), get()) }
    factory { PlayerScreen(get(), get()) }
    factory { MusicListItem(get(), get()) }
}
