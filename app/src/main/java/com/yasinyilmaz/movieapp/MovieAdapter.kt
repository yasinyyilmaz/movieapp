package com.yasinyilmaz.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.semantics.text
import androidx.recyclerview.widget.RecyclerView
import com.yasinyilmaz.movieapp.databinding.ItemMovieBinding

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movieTitle.text = movie.title
        holder.binding.movieGenre.text = movie.genre
        holder.binding.movieRating.text = "⭐ ${movie.rating}"
        holder.binding.movieBackground.setBackgroundResource(movie.imageResId)
    }

    override fun getItemCount() = movies.size
}