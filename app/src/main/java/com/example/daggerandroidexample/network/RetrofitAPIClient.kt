package com.example.daggerandroidexample.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


/*
class RetrofitAPIClient {

    companion object {
        @JvmStatic
        private lateinit var retrofit: Retrofit

        @JvmStatic
        fun getClient(baseUrl: String, context: Context): Retrofit {
            retrofit = Retrofit.Builder().baseUrl(baseUrl).client(getHttpClient(context))
                .addConverterFactory(
                    GsonConverterFactory.create(
                        getGson()
                    )
                )
                .build()

            return retrofit
        }

        @JvmStatic
        private fun getGson(): Gson {
            return GsonBuilder().create()
        }

        @JvmStatic
        fun getHttpClient(context: Context): OkHttpClient {
            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(getHttpLoggingInterceptor())
            httpClientBuilder.cache(getCache(context))
            return httpClientBuilder.build()
        }

        @JvmStatic
        private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            return logging
        }

        @JvmStatic
        private fun getFileCache(context: Context): File {
            val cacheFile = File(context.cacheDir, "HttpCache")
            cacheFile.mkdirs()
            return cacheFile
        }

        @JvmStatic
        private fun getCache(context: Context): Cache {
            return Cache(getFileCache(context), 10000000L)
        }

        @JvmStatic
        private fun getOkHttpDownloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
            return OkHttp3Downloader(okHttpClient)
        }

        @JvmStatic
        fun getPicasso(context: Context, okHttpClient: OkHttpClient): Picasso {
            return Picasso.Builder(context).downloader(getOkHttpDownloader(okHttpClient)).build()
        }
    }

}*/
