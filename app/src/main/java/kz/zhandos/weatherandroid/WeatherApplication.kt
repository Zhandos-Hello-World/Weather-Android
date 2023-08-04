package kz.zhandos.weatherandroid

import android.app.Application
import kz.zhandos.lib.core.data.di.coreDataModule
import kz.zhandos.lib.core.data.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApplication)
            modules(
                coreDataModule(BuildConfig.BASE_URL)
            )
        }
    }
}