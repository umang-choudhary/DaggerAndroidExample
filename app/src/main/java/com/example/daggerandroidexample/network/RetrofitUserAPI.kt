package com.example.daggerandroidexample.network

import com.example.daggerandroidexample.utils.USER_API
import com.example.daggerandroidexample.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitUserAPI {

    @GET(USER_API)
    fun getRandomUsers(@Query("results") size: Int): Call<UserResponse>
}