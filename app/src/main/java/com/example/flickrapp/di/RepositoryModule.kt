package com.example.flickrapp.di

import com.example.flickrapp.repository.Repository
import com.example.flickrapp.repository.RepositoryImpl
import com.example.flickrapp.repository.local.UsersDao
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository
}