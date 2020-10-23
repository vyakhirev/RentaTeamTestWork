package com.example.flickrapp.repository

import com.example.flickrapp.data.UserItem
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

interface Repository {
    fun getUsers(): Single<List<UserItem>>
    fun getPage(): Int
    fun getPerPage(): Int
    fun getTotalUsers():Int
    fun getTotalPages(): Int
}
