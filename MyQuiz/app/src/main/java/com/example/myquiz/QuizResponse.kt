package com.example.myquiz

data class QuizResponse(
    val response_code: Int,
    val results: List<HistoryDataItem>
)

