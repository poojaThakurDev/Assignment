package com.example.movielistapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistapp.databinding.ItemMovieListBinding
import com.squareup.picasso.Picasso

class MovieAdapter(private var moviesList : List<ResultsItem> = mutableListOf()) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemMovieListBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(movie:ResultsItem){
           Picasso.get()
               .load("https://image.tmdb.org/t/p/original/${movie.poster_path}")
               .into(binding.ivMovie)

           binding.tvMovieName.text = movie.original_title ?:"name"
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(moviesList[position])
    }
}