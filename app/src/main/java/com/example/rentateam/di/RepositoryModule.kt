package com.example.rentateam.di

import com.example.rentateam.repository.Repository
import com.example.rentateam.repository.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository
}