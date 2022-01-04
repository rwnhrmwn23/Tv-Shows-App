package com.onedev.tvshowsapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onedev.tvshowsapp.R
import com.onedev.tvshowsapp.databinding.ItemContainerTvShowsBinding
import com.onedev.tvshowsapp.model.TVShows

class TvShowsAdapter: RecyclerView.Adapter<TvShowsAdapter.TvShowViewHolder>() {

    private var tvShows = ArrayList<TVShows>()
    var onItemClick: ((TVShows) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setListTvShows(listTvShow: List<TVShows>) {
        tvShows.clear()
        tvShows.addAll(listTvShow)
        notifyDataSetChanged()
    }

    inner class TvShowViewHolder(private val binding: ItemContainerTvShowsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTvShow(tvShow: TVShows) {
            binding.tvShow = tvShow
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ItemContainerTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bindTvShow(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size
}