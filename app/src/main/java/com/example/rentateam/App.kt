package com.example.rentateam

import androidx.multidex.MultiDexApplication
import com.example.rentateam.di.AppComponent

open class App : MultiDexApplication() {

//    private val cicerone = Cicerone.create()
//    val router get() = cicerone.router
//    val navigatorHolder get() = cicerone.getNavigatorHolder()

    companion object {

        private var appComponent: AppComponent? = null
//        internal lateinit var INSTANCE: App
//            private set
    }

    override fun onCreate() {
        super.onCreate()
//        INSTANCE = this
        getAppComponent().inject(this)
    }

    open fun getAppComponent(): AppComponent {
        return appComponent ?: AppComponent.create(this).
        also {
            appComponent = it
        }
    }
}