package com.example.daggerandroidexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("seed")
    @Expose
    val seed: String,

    @SerializedName("results")
    @Expose
    val results: Int,

    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("version")
    @Expose
    val version: String
)
