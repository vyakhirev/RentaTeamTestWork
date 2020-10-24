package com.example.rentateam.repository

import com.example.rentateam.data.UserItem
import io.reactivex.Single

interface Repository {
    fun getUsers(): Single<List<UserItem>>
    fun getPage(): Int
    fun getPerPage(): Int
    fun getTotalUsers():Int
    fun getTotalPages(): Int
}
