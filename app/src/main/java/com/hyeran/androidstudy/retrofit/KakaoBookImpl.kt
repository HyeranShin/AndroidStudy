package com.hyeran.androidstudy.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KakaoBookImpl {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dapi.kakao.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: KakaoBookService = retrofit.create(KakaoBookService::class.java)
}