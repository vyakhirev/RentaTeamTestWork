package com.example.flickrapp.repository

import android.util.Log
import com.example.flickrapp.data.UserItem
import com.example.flickrapp.repository.local.UsersDao
import com.example.flickrapp.repository.remote.ApiService
import io.reactivex.Single
import javax.inject.Inject


class RepositoryImpl @Inject
constructor(
        private val apiService: ApiService,
        private val usersDao: UsersDao
) : Repository {

    override fun getUsers(): Single<List<UserItem>> {

        var cacheIsDirty = false

        if ((0..6).random() < 3)
            cacheIsDirty = true

        return if (cacheIsDirty)
            getFromRemote()
        else
            getFromLocal()
    }

    override fun getPage(): Int {
        TODO("Not yet implemented")
    }

    override fun getPerPage(): Int {
        TODO("Not yet implemented")
    }

    override fun getTotalUsers(): Int {
        TODO("Not yet implemented")
    }

    override fun getTotalPages(): Int {
        TODO("Not yet implemented")
    }

    private fun getFromRemote(): Single<List<UserItem>> {
        Log.d("debug", "Get from remote")
        return apiService.getUsers()
                .map {
                    it.data
                }
                .doOnSuccess {
                    storeLocally(it)
                }
    }

    private fun storeLocally(users: List<UserItem>) {
        usersDao.insertAll(users)
                .subscribe()
    }

    private fun getFromLocal(): Single<List<UserItem>> {
        Log.d("debug", "Get from local")
        return usersDao.getAllUsers()

    }

}