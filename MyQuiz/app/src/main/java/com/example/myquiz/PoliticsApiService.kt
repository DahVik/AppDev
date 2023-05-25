package com.example.myquiz

import retrofit2.Call
import retrofit2.http.GET

interface PoliticsApiService {
    @GET("api.php?amount=5&category=24&type=multiple")
    fun getQuizData(): Call<PolQuizResponse>
}