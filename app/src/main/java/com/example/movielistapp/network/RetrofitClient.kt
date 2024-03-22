package com.example.movielistapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val BEARER_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMWE3ZDAxZWQ2ZGRkYTc5NTRhY2Q4NTdkYTQ1MGZmMSIsInN1YiI6IjY1ZmFhYjIyMGJjNTI5MDE2MmFkZWIxMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-9-lBOZF1tUzeuNj9aXRtWwbp0Km1SOLSwPun3_kfmE"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val requestWithAuthorization = originalRequest.newBuilder()
                .header("Authorization", "Bearer $BEARER_TOKEN")
                .build()
            chain.proceed(requestWithAuthorization)
        }
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)
}
