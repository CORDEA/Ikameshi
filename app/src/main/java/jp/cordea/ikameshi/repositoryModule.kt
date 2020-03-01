package jp.cordea.ikameshi

import org.koin.dsl.module

val repositoryModule = module {
    single { MusicRepository() }
    single { MusicPreferenceRepository() }
}
