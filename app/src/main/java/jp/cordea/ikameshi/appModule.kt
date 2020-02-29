package jp.cordea.ikameshi

import org.koin.dsl.module

val appModule = module {
    single { Reducer(get()) }
}
