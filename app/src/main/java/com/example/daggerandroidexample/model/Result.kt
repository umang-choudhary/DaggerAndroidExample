package com.example.daggerandroidexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("gender")
    @Expose
    val gender: String,

    @SerializedName("name")
    @Expose
    val name: Name,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("picture")
    @Expose
    val picture: Picture
)
