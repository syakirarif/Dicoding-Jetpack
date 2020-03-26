package com.syakir.moviecatalogue.model

data class TvShowEntity(
    val tvShowId: String,
    val title: String,
    val vote_avg: String,
    val overview: String,
    val first_air_date: String,
    val poster_path: String,
    val backdrop_path: String
)