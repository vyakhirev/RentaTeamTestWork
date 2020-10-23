package com.example.flickrapp.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flickrapp.data.UserItem

@Database(entities = [UserItem::class], version = 1)
abstract class UsersDatabase : RoomDatabase(){
   abstract fun usersDao(): UsersDao
}