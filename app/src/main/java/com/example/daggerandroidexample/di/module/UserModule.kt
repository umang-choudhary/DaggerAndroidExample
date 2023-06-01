package com.example.daggerandroidexample.di.module

import com.example.daggerandroidexample.di.qualifier.BaseUrl
import com.example.daggerandroidexample.di.scope.PerApplication
import com.example.daggerandroidexample.network.RetrofitUserAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpClientModule::class])
object UserModule {

    @Provides
    @PerApplication
    fun provideUserApi(retrofit: Retrofit): RetrofitUserAPI {
        return retrofit.create(RetrofitUserAPI::class.java)
    }

    @Provides
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }

}