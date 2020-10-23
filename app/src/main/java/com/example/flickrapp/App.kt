package com.example.flickrapp

import androidx.multidex.MultiDexApplication
import com.example.flickrapp.di.AppComponent

class App : MultiDexApplication() {

    companion object {

        private var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        getAppComponent().inject(this)
    }

    open fun getAppComponent(): AppComponent {
        return appComponent ?: AppComponent.create(this).
        also {
            appComponent = it
        }
    }
}