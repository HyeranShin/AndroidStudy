package com.hyeran.androidstudy.retrofit

data class ResponseDto(
    val documents: List<BookResponseDto>
)

data class BookResponseDto(
    val title: String,
    val contents: String,
    val url: String,
    val authors: List<String>,
    val thumbnail: String
)