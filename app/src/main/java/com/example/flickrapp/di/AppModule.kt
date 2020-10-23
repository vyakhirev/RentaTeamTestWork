package com.example.flickrapp.di

import android.content.Context
import androidx.room.Room
import com.example.flickrapp.repository.local.UsersDao
import com.example.flickrapp.repository.local.UsersDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context : Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideDataBase(context: Context): UsersDatabase {
        return Room.databaseBuilder(context, UsersDatabase::class.java, "db_demo").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: UsersDatabase): UsersDao {
        return database.usersDao()
    }
}