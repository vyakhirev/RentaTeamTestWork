package com.example.rentateam.di

import com.example.rentateam.di.db.DatabaseModule
import com.example.rentateam.repository.Repository
import com.example.rentateam.repository.local.UsersDao
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
        modules = [DatabaseModule::class,ApiModule::class,RepositoryModule::class]
)
interface RepositoryComponent {
    fun provideRepository():Repository
    fun provideDUserDao():UsersDao
}