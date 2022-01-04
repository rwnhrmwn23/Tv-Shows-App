package com.onedev.tvshowsapp.model

import com.google.gson.annotations.SerializedName

data class TVShowsResponse(
    val page: Int,
    @SerializedName("pages") val totalPages: Int,
    @SerializedName("tv_shows") val tvShows: List<TVShows>,
)
