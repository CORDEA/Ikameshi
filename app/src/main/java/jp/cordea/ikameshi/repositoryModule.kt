package jp.cordea.ikameshi

import jp.cordea.ikameshi.repository.MusicPreferenceRepository
import jp.cordea.ikameshi.repository.MusicRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MusicRepository() }
    single { MusicPreferenceRepository() }
}
