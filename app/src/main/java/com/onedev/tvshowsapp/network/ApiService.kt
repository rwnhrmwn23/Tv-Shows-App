package com.onedev.tvshowsapp.network

import com.onedev.tvshowsapp.model.TVShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("most-popular")
    fun getMostPopularTvShows(
        @Query("page") page: Int
    ): Call<TVShowsResponse>
}