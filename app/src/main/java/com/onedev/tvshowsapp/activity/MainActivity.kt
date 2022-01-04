package com.onedev.tvshowsapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.onedev.tvshowsapp.adapter.TvShowsAdapter
import com.onedev.tvshowsapp.databinding.ActivityMainBinding
import com.onedev.tvshowsapp.viewmodel.MostPopularTvShowViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tvShowsAdapter: TvShowsAdapter
    private lateinit var viewModel: MostPopularTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doInitialization()
    }

    private fun doInitialization() {
        tvShowsAdapter = TvShowsAdapter()
        viewModel = ViewModelProvider(this@MainActivity)[MostPopularTvShowViewModel::class.java]
        binding.rvTvShows.apply {
            setHasFixedSize(true)
            adapter = tvShowsAdapter
            getPopularTvShows()
        }
    }

    private fun getPopularTvShows() {
        binding.isLoading = true
        viewModel.getMostPopularTvShows(1).observe(this) {
            tvShowsAdapter.setListTvShows(it.tvShows)
            binding.isLoading = false
        }
    }
}