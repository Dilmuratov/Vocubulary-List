package com.example.vocabularylist.app

import android.app.Application
import com.example.vocabularylist.di.appModule
import com.example.vocabularylist.di.dataModule
import com.example.vocabularylist.di.domainModule
import com.example.vocabularylist.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, dataModule, domainModule, localModule))
            androidContext(this@App)
        }
    }
}