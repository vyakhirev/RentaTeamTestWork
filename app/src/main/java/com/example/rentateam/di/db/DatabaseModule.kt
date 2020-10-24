package com.example.rentateam.di.db

import android.app.Application
import androidx.room.Room
import com.example.rentateam.repository.local.UsersDao
import com.example.rentateam.repository.local.UsersDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_NAME = "USERS"

@Module
class DatabaseModule(mApplication: Application) {
    private val usersDatabase: UsersDatabase = Room
            .databaseBuilder(mApplication, UsersDatabase::class.java, DB_NAME)
            .build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): UsersDatabase {
        return usersDatabase
    }

    @Singleton
    @Provides
    fun providesmovieDao(usersDatabase: UsersDatabase): UsersDao {
        return usersDatabase.usersDao()
    }
}
