package com.onedev.tvshowsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.tvshowsapp.model.TVShowsResponse
import com.onedev.tvshowsapp.repository.MostPopularTvShowRepository

class MostPopularTvShowViewModel: ViewModel() {

    private lateinit var mostPopularTvShowRepository: MostPopularTvShowRepository

    fun getMostPopularTvShows(page: Int): LiveData<TVShowsResponse> {
        mostPopularTvShowRepository = MostPopularTvShowRepository()
        return mostPopularTvShowRepository.getMostPopularTvShows(page)
    }
}