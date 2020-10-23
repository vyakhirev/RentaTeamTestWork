package com.example.flickrapp

import com.example.flickrapp.di.AppComponent
import com.example.flickrapp.di.DaggerTestAppComponent

class TestApp : App() {

    override fun getAppComponent(): AppComponent {
        return DaggerTestAppComponent.builder().build()
    }
}