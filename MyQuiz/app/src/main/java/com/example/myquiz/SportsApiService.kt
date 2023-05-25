package com.example.myquiz

import retrofit2.Call
import retrofit2.http.GET

interface SportsApiService {
    @GET("api.php?amount=5&category=21&type=multiple")
    fun getQuizData(): Call<SportsQuizResponse>
}