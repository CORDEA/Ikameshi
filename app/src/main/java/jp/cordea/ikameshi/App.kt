package jp.cordea.ikameshi

import android.app.Application
import jp.cordea.ikameshi.di.appModule
import jp.cordea.ikameshi.di.repositoryModule
import jp.cordea.ikameshi.di.screenModule
import jp.cordea.ikameshi.di.storeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    repositoryModule,
                    appModule,
                    storeModule,
                    screenModule
                )
            )
        }
    }
}
