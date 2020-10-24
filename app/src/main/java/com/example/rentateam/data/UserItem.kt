package com.example.rentateam.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserItem(
        @field:PrimaryKey
        var id : Int,
        var email: String,
        var first_name: String,
        var last_name: String,
        var avatar: String
)