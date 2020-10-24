package com.example.rentateam.di

import android.app.Application
import android.content.Context
import com.example.rentateam.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApiModule::class])
@Singleton
interface AppComponent  {

    companion object {

        private var appComponent: AppComponent? = null

        fun create(application: Application): AppComponent {
            return appComponent ?: DaggerAppComponent
                    .builder()
                    .application(application)
                    .build().also {
                        appComponent = it
                    }
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}