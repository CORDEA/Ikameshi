package jp.cordea.ikameshi.di

import jp.cordea.ikameshi.Dispatcher
import jp.cordea.ikameshi.action.Actions
import org.koin.dsl.module

val appModule = module {
    single { Dispatcher() }
    single { Actions(get()) }
}
