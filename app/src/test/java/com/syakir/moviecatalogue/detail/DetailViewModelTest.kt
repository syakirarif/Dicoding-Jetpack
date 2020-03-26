package com.syakir.moviecatalogue.detail

import com.syakir.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val dummyTvShows = DataDummy.generateDummyTvShows()[0]

    private val movieId = dummyMovies.movieId
    private val showId = dummyTvShows.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getDetailMovie() {
        viewModel.selectedExtraId(movieId)
        val movieEntity = viewModel.getDetailMovie()

        // memastikan data movieEntity tidak kosong
        assertNotNull(movieEntity)

        // mengecek kecocokan data setiap detail movie
        assertEquals(dummyMovies.movieId, movieEntity.movieId)
        assertEquals(dummyMovies.poster_path, movieEntity.poster_path)
        assertEquals(dummyMovies.backdrop_path, movieEntity.backdrop_path)
        assertEquals(dummyMovies.overview, movieEntity.overview)
        assertEquals(dummyMovies.release_date, movieEntity.release_date)
        assertEquals(dummyMovies.title, movieEntity.title)
        assertEquals(dummyMovies.vote_avg, movieEntity.vote_avg)
    }

    @Test
    fun getDetailTvShow() {
        viewModel.selectedExtraId(showId)
        val showEntity = viewModel.getDetailTvShow()

        // memastikan data showEntity tidak kosong
        assertNotNull(showEntity)

        // mengecek kecocokan data setiap detail tv show
        assertEquals(dummyTvShows.tvShowId, showEntity.tvShowId)
        assertEquals(dummyTvShows.poster_path, showEntity.poster_path)
        assertEquals(dummyTvShows.backdrop_path, showEntity.backdrop_path)
        assertEquals(dummyTvShows.overview, showEntity.overview)
        assertEquals(dummyTvShows.first_air_date, showEntity.first_air_date)
        assertEquals(dummyTvShows.title, showEntity.title)
        assertEquals(dummyTvShows.vote_avg, showEntity.vote_avg)
    }
}