package com.example.flickrapp.di.viewmodel

import com.example.flickrapp.di.RepositoryModule
import com.example.flickrapp.di.ApiModule
import com.example.flickrapp.di.AppModule
import com.example.flickrapp.di.db.DatabaseModule
import com.example.flickrapp.ui.listusers.ListUsersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ViewModelModule::class, RepositoryModule::class,ApiModule::class,AppModule::class]
)
interface ViewModelComponent : ViewModelsProvider {
    fun inject(listUsersFragment: ListUsersFragment)
}