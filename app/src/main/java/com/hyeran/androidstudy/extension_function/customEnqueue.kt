package com.hyeran.androidstudy.extension_function

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <ResponseType> Call<ResponseType>.customEnqueue(
    onFail: (message: String) -> Unit,
    onSuccess: (ResponseType) -> Unit,
    onError: (message: String) -> Unit
) {
    this.enqueue(object : Callback<ResponseType> {
        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            onFail("통신 상태를 확인해주세요.")
        }

        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            response.body()?.let {
                onSuccess(it) //통신 결과 전달
            } ?: onError("에러 코드: ${response.code()}")
        }
    })
}