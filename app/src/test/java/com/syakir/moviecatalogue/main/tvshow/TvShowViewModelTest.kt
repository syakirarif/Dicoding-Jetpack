package com.syakir.moviecatalogue.main.tvshow

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val showEntities = viewModel.getTvShows()

        // memastikan data showEntities tidak kosong
        assertNotNull(showEntities)

        // memastikan kecocokan banyak data yang ditampilkan
        assertEquals(12, showEntities.size)
    }
}