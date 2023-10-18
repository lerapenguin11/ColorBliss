package com.example.colorbliss.app

import android.app.Application
import com.example.colorbliss.di.appModule
import com.example.colorbliss.di.dataModule
import com.example.colorbliss.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //указывает насколько подробно нужно выводить ошибки
            androidLogger(Level.DEBUG)
            //context который будет использоваться в dataModule
            androidContext(this@App)
            modules(listOf(appModule,
                domainModule,
                dataModule))
        }
    }
}