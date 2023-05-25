package com.example.myquiz

import retrofit2.Call
import retrofit2.http.GET

interface HistoryApiService {
    @GET("api.php?amount=5&category=23&type=multiple")
    fun getQuizData(): Call<QuizResponse>
}

