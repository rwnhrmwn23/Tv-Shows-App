package com.onedev.tvshowsapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.onedev.tvshowsapp.R
import com.onedev.tvshowsapp.viewmodel.MostPopularTvShowViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MostPopularTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this@MainActivity)[MostPopularTvShowViewModel::class.java]

        getPopularTvShows()
    }

    private fun getPopularTvShows() {
        viewModel.getMostPopularTvShows(1).observe(this) {
            Toast.makeText(this@MainActivity, "Total Pages: ${it.totalPages}", Toast.LENGTH_SHORT).show()
        }
    }
}