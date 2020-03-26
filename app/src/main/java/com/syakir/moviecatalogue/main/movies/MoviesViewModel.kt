package com.syakir.moviecatalogue.main.movies

import androidx.lifecycle.ViewModel
import com.syakir.moviecatalogue.model.MovieEntity
import com.syakir.moviecatalogue.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies() : List<MovieEntity> = DataDummy.generateDummyMovies()
}