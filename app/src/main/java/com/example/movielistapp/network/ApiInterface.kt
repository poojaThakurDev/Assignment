package com.example.movielistapp.network

import com.example.movielistapp.ui.home.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
     fun getMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Call<MovieResponse>
}