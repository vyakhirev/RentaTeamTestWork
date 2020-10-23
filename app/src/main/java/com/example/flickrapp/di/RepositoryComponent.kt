package com.example.flickrapp.di

import com.example.flickrapp.di.db.DatabaseModule
import com.example.flickrapp.repository.Repository
import com.example.flickrapp.repository.local.UsersDao
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