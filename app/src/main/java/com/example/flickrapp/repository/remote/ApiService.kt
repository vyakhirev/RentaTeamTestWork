package com.example.flickrapp.repository.remote

import com.example.flickrapp.data.UserResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/users")
    fun getUsers(): Single<UserResponse>

}