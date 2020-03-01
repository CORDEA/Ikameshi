package jp.cordea.ikameshi

import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule = module {
    scope(named<MainActivity>()) {
        scoped { Store(get()) }
        scoped { Actions(get(), get(), get(), get()) }
    }
}
