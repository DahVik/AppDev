package com.example.myquiz

data class PolQuizResponse(
    val response_code: Int,
    val results: List<PoliticsDataItem>
)