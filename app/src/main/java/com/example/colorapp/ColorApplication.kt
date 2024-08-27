package com.example.colorapp

import android.app.Application
import com.example.colorapp.dependencyinjection.appModule
import com.example.colorapp.dependencyinjection.fbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ColorApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ColorApplication)
            //androidContext(this@ColorApplication): This line provides the Android application context to Koin,
            // which is necessary for any dependency that relies on the context (e.g., database builders, shared preferences).
            modules(listOf(appModule, fbModule))
        }
    }
}