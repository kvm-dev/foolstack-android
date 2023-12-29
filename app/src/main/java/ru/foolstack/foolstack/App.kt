package ru.foolstack.foolstack

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.foolstack.splash.di.splashModule

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(splashModule )
        }
    }
}