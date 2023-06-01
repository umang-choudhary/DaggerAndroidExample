package com.example.daggerandroidexample.app

import android.app.Application
import com.example.daggerandroidexample.di.component.DaggerUserComponent
import com.example.daggerandroidexample.di.component.UserComponent
import com.example.daggerandroidexample.utils.BASE_URL

class UserApplication : Application() {

    private lateinit var userComponent: UserComponent

    override fun onCreate() {
        super.onCreate()

        userComponent = DaggerUserComponent.factory().create(BASE_URL, applicationContext)
    }

    fun getUserComponent(): UserComponent {
        return userComponent
    }

}