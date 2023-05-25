package com.example.myquiz

import retrofit2.Call
import retrofit2.http.GET

interface GeoApiService {
    @GET("api.php?amount=5&category=22&type=multiple")
    fun getQuizData(): Call<GeoQuizResponse>
}