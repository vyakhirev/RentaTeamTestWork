package com.example.rentateam.di

import android.app.Application
import android.content.Context
import com.example.rentateam.App
import com.example.rentateam.di.api.ApiModule
import com.example.rentateam.di.cicerone_nav.NavigationModule
import com.example.rentateam.di.db.DatabaseModule
import com.example.rentateam.di.repository.RepositoryModule
import com.example.rentateam.di.viewmodel.ViewModelModule
import com.example.rentateam.ui.MainActivity
import com.example.rentateam.ui.listusers.ListUsersFragment
import com.example.rentateam.ui.usercard.UserCardFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    ApiModule::class,
    NavigationModule::class,
    ViewModelModule::class,
    RepositoryModule::class,
    DatabaseModule::class
])
@Singleton
interface AppComponent {

    companion object {

        private var appComponent: AppComponent? = null

        fun create(application: Application): AppComponent {
            return appComponent ?: DaggerAppComponent
                    .builder()
                    .application(application)
                    .dataBase(DatabaseModule(application))
                    .build().also {
                        appComponent = it
                    }
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun dataBase(databaseModule: DatabaseModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

    fun inject(activity: MainActivity)

    fun inject(listUsersFragment: ListUsersFragment)

    fun inject(userCardFragment: UserCardFragment)

}