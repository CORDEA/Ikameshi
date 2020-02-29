package jp.cordea.ikameshi

import org.koin.dsl.module

val actionModule = module {
    single { ChangeTab() }
    single { FetchMusics(get()) }
}
