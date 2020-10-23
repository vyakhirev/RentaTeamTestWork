package com.example.flickrapp.di.db

import com.example.flickrapp.repository.local.UsersDao
import com.example.flickrapp.repository.local.UsersDatabase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ DatabaseModule::class]
)
interface DatabaseComponent {
    fun provideDatabase(): UsersDatabase

    fun usersDao(): UsersDao
}