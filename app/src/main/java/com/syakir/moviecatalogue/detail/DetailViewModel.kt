package com.syakir.moviecatalogue.detail

import androidx.lifecycle.ViewModel
import com.syakir.moviecatalogue.model.MovieEntity
import com.syakir.moviecatalogue.model.TvShowEntity
import com.syakir.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var extraId: String

    fun selectedExtraId(extraId: String) {
        this.extraId = extraId
    }

    fun getDetailMovie(): MovieEntity {
        lateinit var movie: MovieEntity

        val movieEntities = DataDummy.generateDummyMovies()

        for (entity in movieEntities) {
            if (entity.movieId == extraId) {
                movie = entity
            }
        }

        return movie
    }

    fun getDetailTvShow(): TvShowEntity {
        lateinit var show: TvShowEntity

        val showEntities = DataDummy.generateDummyTvShows()

        for (entity in showEntities) {
            if (entity.tvShowId == extraId) {
                show = entity
            }
        }

        return show
    }
}