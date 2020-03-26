package com.syakir.moviecatalogue.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.syakir.moviecatalogue.BuildConfig
import com.syakir.moviecatalogue.R
import com.syakir.moviecatalogue.model.MovieEntity
import com.syakir.moviecatalogue.model.TvShowEntity
import com.syakir.moviecatalogue.utils.DateConverter
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras

        if (extras != null) {
            val extraId = extras.getString(EXTRA_ID)
            val extraType = extras.getString(EXTRA_TYPE)

            if (extraId != null && extraType != null) {
                viewModel.selectedExtraId(extraId)

                when (extraType) {
                    "movie" -> populateMovies(viewModel.getDetailMovie())
                    "tv" -> populateTvShow(viewModel.getDetailTvShow())
                }

            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovies(entity: MovieEntity) {
        tv_title.text = entity.title

        Glide.with(this)
            .load(BuildConfig.BASE_URL_IMAGE + entity.poster_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.progressbar_blue_round)
                    .error(R.drawable.image_blank)
            )
            .into(img_detail_poster)

        Glide.with(this)
            .load(BuildConfig.BASE_URL_IMAGE + entity.backdrop_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.progressbar_blue_round)
                    .error(R.drawable.image_blank)
            )
            .into(img_detail_backdrop)

        rating_star.rating = entity.vote_avg.toFloat()
        tv_avg_rating.text = StringBuilder("Rating: " + entity.vote_avg)

        tv_date_title.text = "Release Date"
        tv_overview.text = entity.overview
        tv_release_date.text = DateConverter.getLongDate(entity.release_date)
    }

    @SuppressLint("SetTextI18n")
    private fun populateTvShow(entity: TvShowEntity) {
        tv_title.text = entity.title

        Glide.with(this)
            .load(BuildConfig.BASE_URL_IMAGE + entity.poster_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.progressbar_blue_round)
                    .error(R.drawable.image_blank)
            )
            .into(img_detail_poster)

        Glide.with(this)
            .load(BuildConfig.BASE_URL_IMAGE + entity.backdrop_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.progressbar_blue_round)
                    .error(R.drawable.image_blank)
            )
            .into(img_detail_backdrop)

        rating_star.rating = entity.vote_avg.toFloat()
        tv_avg_rating.text = "Rating: " + entity.vote_avg

        tv_date_title.text = "First Air Date"
        tv_overview.text = entity.overview
        tv_release_date.text = DateConverter.getLongDate(entity.first_air_date)
    }
}
