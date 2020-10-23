package com.example.flickrapp.di

import com.example.flickrapp.ui.listusers.ListUsersFragmentTest
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitTestModule::class])
@Singleton
interface TestAppComponent : AppComponent {


    fun inject(listPhotosFragmentTest: ListUsersFragmentTest)
}