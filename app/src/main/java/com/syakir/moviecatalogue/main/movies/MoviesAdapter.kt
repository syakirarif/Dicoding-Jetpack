package com.syakir.moviecatalogue.main.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.syakir.moviecatalogue.R
import com.syakir.moviecatalogue.detail.DetailActivity
import com.syakir.moviecatalogue.model.MovieEntity
import kotlinx.android.synthetic.main.item_poster.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        listMovies.clear()
        listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poster, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MovieEntity) {
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.progressbar_blue_round)
                        .error(R.drawable.image_blank)
                )
                .into(itemView.img_poster)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_ID, movie.movieId)
                    putExtra(DetailActivity.EXTRA_TYPE, "movie")
                }
                itemView.context.startActivity(intent)
            }

        }

    }
}