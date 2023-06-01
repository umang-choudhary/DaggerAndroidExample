package com.example.daggerandroidexample.di.component

import android.content.Context
import com.example.daggerandroidexample.di.module.PicassoModule
import com.example.daggerandroidexample.di.qualifier.ActivityContext
import com.example.daggerandroidexample.di.scope.PerActivity
import com.example.daggerandroidexample.view.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivity
@Subcomponent(
    modules = [PicassoModule::class]
)
interface ActivityComponent {

    fun injectMainActivity(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context
        ): ActivityComponent
    }

}