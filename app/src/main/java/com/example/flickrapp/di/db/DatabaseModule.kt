package com.example.flickrapp.di.db

import android.app.Application
import androidx.room.Room
import com.example.flickrapp.repository.local.UsersDao
import com.example.flickrapp.repository.local.UsersDatabase
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

//@Module
//class DatabaseModule(mApplication: Application) {
//
//    val context = mApplication
//
//    @Provides
//    @Reusable
//    fun provideUsersDao(usersDatabase: UsersDatabase): UsersDao {
//        return usersDatabase.usersDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideUserDatabase(): UsersDatabase {
//        return Room.databaseBuilder(
//                context,
//                UsersDatabase::class.java, USERS_DATABASE_NAME
//        ).build()
//    }
//}