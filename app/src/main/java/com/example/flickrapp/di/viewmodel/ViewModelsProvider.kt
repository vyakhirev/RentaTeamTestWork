package com.example.flickrapp.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flickrapp.repository.Repository
import com.example.flickrapp.repository.local.UsersDao

interface ViewModelsProvider {

    fun provideMap(): @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel>

    fun provideViewModel(): ViewModelProvider.Factory

}