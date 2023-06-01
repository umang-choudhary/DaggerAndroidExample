package com.example.daggerandroidexample.di.module

import android.content.Context
import com.example.daggerandroidexample.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File

@Module
object OkHttpClientModule {

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.addInterceptor(httpLoggingInterceptor)
        httpClientBuilder.cache(cache)
        return httpClientBuilder.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    fun providesFile(@ApplicationContext context: Context): File {
        val cacheFile = File(context.cacheDir, "HttpCache")
        cacheFile.mkdirs()
        return cacheFile
    }

    @Provides
    fun providesCache(file: File): Cache {
        return Cache(file, 10000000L)
    }

}