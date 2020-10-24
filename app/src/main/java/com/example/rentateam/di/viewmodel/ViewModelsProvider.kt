package com.example.rentateam.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface ViewModelsProvider {

    fun provideMap(): @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel>

    fun provideViewModel(): ViewModelProvider.Factory

}