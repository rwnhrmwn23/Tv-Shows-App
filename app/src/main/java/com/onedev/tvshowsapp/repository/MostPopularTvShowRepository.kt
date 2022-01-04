package com.onedev.tvshowsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onedev.tvshowsapp.model.TVShowsResponse
import com.onedev.tvshowsapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MostPopularTvShowRepository {

    private var apiService = ApiClient.getRetrofit()

    fun getMostPopularTvShows(page: Int): LiveData<TVShowsResponse> {
        val data = MutableLiveData<TVShowsResponse>()
        apiService?.getMostPopularTvShows(page)?.enqueue(object : Callback<TVShowsResponse> {
            override fun onResponse(call: Call<TVShowsResponse>, response: Response<TVShowsResponse>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<TVShowsResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}