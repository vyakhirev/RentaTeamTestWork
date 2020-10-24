package com.example.rentateam.di.db

import com.example.rentateam.repository.local.UsersDao
import com.example.rentateam.repository.local.UsersDatabase
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