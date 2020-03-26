package com.syakir.moviecatalogue.main.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.syakir.moviecatalogue.R
import com.syakir.moviecatalogue.detail.DetailActivity
import com.syakir.moviecatalogue.model.TvShowEntity
import kotlinx.android.synthetic.main.item_poster.view.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listShows = ArrayList<TvShowEntity>()

    fun setTvShows(shows: List<TvShowEntity>?) {
        if (shows == null) return
        listShows.clear()
        listShows.addAll(shows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poster, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listShows.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val movie = listShows[position]
        holder.bind(movie)
    }

    inner class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(show: TvShowEntity) {
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500" + show.poster_path)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.progressbar_blue_round)
                        .error(R.drawable.image_blank)
                )
                .into(itemView.img_poster)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_ID, show.tvShowId)
                    putExtra(DetailActivity.EXTRA_TYPE, "tv")
                }
                itemView.context.startActivity(intent)
            }

        }

    }
}