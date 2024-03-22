package com.example.movielistapp.ui.home

data class MovieResponse(
    var isLoading: Boolean = true,
    val page: Int = 0,
    val totalPages: Int = 0,
    val results: List<ResultsItem>? = null,
    val totalResults: Int = 0
)

data class ResultsItem(
    val overview: String = "",
    val originalLanguage: String = "",
    val original_title: String = "",
    val video: Boolean = false,
    val title: String = "",
    val genreIds: List<Int>?,
    val poster_path: String = "",
    val backdropPath: String = "",
    val releaseDate: String = "",
    val popularity: Double = 0.0,
    val voteAverage: Double = 0.0,
    val id: Int = 0,
    val adult: Boolean = false,
    val voteCount: Int = 0
)