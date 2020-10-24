package com.example.rentateam

import androidx.multidex.MultiDexApplication
import com.example.rentateam.di.AppComponent

open class App : MultiDexApplication() {

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