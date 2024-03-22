package com.example.movielistapp.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movielistapp.network.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private var moviesMutableLiveData = MutableLiveData<MovieResponse>()
    val moviesLiveData: LiveData<MovieResponse> = moviesMutableLiveData
    private var page: Int = 1

    init {
        getMovies()
    }

    private fun getMovies() {
        val response = RetrofitClient.apiInterface.getMovies(page = page)
        moviesMutableLiveData.value = MovieResponse(isLoading = true)

        response.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.isLoading = false
                    moviesMutableLiveData.value = response.body()
                    page = response.body()?.page ?: 1
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("error", t.toString())
            }

        })

    }

}