package com.syakir.moviecatalogue.main.movies

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MoviesViewModelTest {
    
    private lateinit var viewModel : MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()

        // memastikan data movieEntities tidak kosong
        assertNotNull(movieEntities)

        // memastikan kecocokan banyak data yang ditampilkan
        assertEquals(12, movieEntities.size)
    }
}