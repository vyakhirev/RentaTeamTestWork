package com.example.rentateam.di

import com.example.rentateam.BuildConfig
import com.example.rentateam.repository.remote.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitTestModule {

    private val BASE_URL = "http://localhost:8090/"

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
                .newBuilder()
                .build()

        val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .build()

        chain.proceed(newRequest)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Not logging the authkey if not debug
    private val client =
            if (BuildConfig.DEBUG) {
                OkHttpClient().newBuilder()
                        .addInterceptor(loggingInterceptor)
                        .build()
            } else {
                OkHttpClient().newBuilder()
                        .addInterceptor(loggingInterceptor)
                        .build()
            }

    val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideFlickrApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}