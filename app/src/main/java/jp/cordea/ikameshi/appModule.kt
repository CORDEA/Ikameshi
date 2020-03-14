package jp.cordea.ikameshi

import jp.cordea.ikameshi.action.Actions
import org.koin.dsl.module

val appModule = module {
    single { Dispatcher() }
    single { Actions(get()) }
}
