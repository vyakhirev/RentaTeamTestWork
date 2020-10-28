package com.example.rentateam.di.viewmodel

import com.example.rentateam.di.AppModule
import com.example.rentateam.di.api.ApiModule
import com.example.rentateam.di.repository.RepositoryModule
import com.example.rentateam.ui.listusers.ListUsersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ViewModelModule::class, RepositoryModule::class, ApiModule::class, AppModule::class]
)
interface ViewModelComponent : ViewModelsProvider {
    fun inject(listUsersFragment: ListUsersFragment)
}