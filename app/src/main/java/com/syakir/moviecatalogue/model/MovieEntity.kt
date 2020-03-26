package com.syakir.moviecatalogue.model

data class MovieEntity (
    val movieId: String,
    val title: String,
    val vote_avg: String,
    val overview: String,
    val release_date: String,
    val poster_path: String,
    val backdrop_path: String
)