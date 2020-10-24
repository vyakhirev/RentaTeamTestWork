package com.example.rentateam.repository.remote

import com.example.rentateam.data.UserResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/api/users")
    fun getUsers(): Single<UserResponse>

}