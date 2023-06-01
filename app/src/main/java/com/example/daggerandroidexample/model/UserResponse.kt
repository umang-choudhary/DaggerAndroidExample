package com.example.daggerandroidexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("results")
    @Expose
    val results: List<Result>,

    @SerializedName("info")
    @Expose
    val info: Info
)
