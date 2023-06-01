package com.example.daggerandroidexample.di.module

import android.content.Context
import com.example.daggerandroidexample.di.qualifier.ActivityContext
import com.example.daggerandroidexample.di.scope.PerActivity
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [OkHttpClientModule::class])
class PicassoModule {

    @Provides
    @PerActivity
    fun providePicasso(
        @ActivityContext context: Context,
        okHttp3Downloader: OkHttp3Downloader
    ): Picasso {
        return Picasso.Builder(context).downloader(okHttp3Downloader).build()
    }

    @Provides
    fun provideOkHttpDownloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

}