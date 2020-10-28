package com.example.rentateam.di.repository

import com.example.rentateam.di.api.ApiModule
import com.example.rentateam.di.db.DatabaseModule
import com.example.rentateam.repository.Repository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
        modules = [DatabaseModule::class, ApiModule::class, RepositoryModule::class]
)
interface RepositoryComponent {
    fun provideRepository():Repository

}