package com.example.rentateam.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitTestModule::class])
@Singleton
interface TestAppComponent : AppComponent {

}