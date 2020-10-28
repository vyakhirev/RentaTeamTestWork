package com.example.rentateam.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentateam.ui.listusers.ListUsersViewModel
import com.example.rentateam.ui.usercard.UserCardViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {

    companion object {
        @Provides
        @Singleton
        fun viewModelsHolder(): @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel> {
            return HashMap()
        }

    }

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactoryProvider): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListUsersViewModel::class)
    fun bindsListPhotosViewModel(listUsersViewModel: ListUsersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserCardViewModel::class)
    fun bindsUserCardViewModel(userCardViewModel: UserCardViewModel): ViewModel

}