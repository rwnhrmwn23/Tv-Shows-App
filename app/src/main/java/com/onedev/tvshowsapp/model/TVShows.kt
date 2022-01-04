package com.onedev.tvshowsapp.model

import com.google.gson.annotations.SerializedName

data class TVShows(
    val id: String,
    val country: String,
    val name: String,
    val network: String,
    val status: String,
    @SerializedName("start_date") val startData: String,
    @SerializedName("image_thumbnail_path") val thumbnail: String,
)
