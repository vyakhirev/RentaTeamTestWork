package com.example.rentateam.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rentateam.data.UserItem

@Database(entities = [UserItem::class], version = 1)
abstract class UsersDatabase : RoomDatabase(){
   abstract fun usersDao(): UsersDao
}