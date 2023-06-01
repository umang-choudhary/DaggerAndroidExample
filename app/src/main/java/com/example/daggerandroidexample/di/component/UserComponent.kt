package com.example.daggerandroidexample.di.component

import android.content.Context
import com.example.daggerandroidexample.di.module.UserModule
import com.example.daggerandroidexample.di.qualifier.ApplicationContext
import com.example.daggerandroidexample.di.qualifier.BaseUrl
import com.example.daggerandroidexample.di.scope.PerApplication
import dagger.BindsInstance
import dagger.Component

@PerApplication
@Component(
    modules = [UserModule::class]
)
interface UserComponent {

    fun getActivityComponentFactory(): ActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @BaseUrl baseUrl: String,
            @BindsInstance @ApplicationContext context: Context
        ): UserComponent
    }

}