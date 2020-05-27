package com.hyeran.androidstudy.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KakaoBookService {
    @Headers("Authorization: KakaoAK e083a3c4f3b68d250e6bd1c3dff77c7b")
    @GET("/v3/search/book")
    fun getBookList(@Query("query") title: String): Call<ResponseDto>
}