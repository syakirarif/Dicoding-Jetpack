package com.syakir.moviecatalogue.main.tvshow

import androidx.lifecycle.ViewModel
import com.syakir.moviecatalogue.model.TvShowEntity
import com.syakir.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShows() : List<TvShowEntity> = DataDummy.generateDummyTvShows()
}