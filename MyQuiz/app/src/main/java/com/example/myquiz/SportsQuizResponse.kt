package com.example.myquiz

data class SportsQuizResponse(
    val response_code: Int,
    val results: List<SportsDataItem>
)