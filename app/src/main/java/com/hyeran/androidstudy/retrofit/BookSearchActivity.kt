package com.hyeran.androidstudy.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.hyeran.androidstudy.R
import com.hyeran.androidstudy.common.showToast
import kotlinx.android.synthetic.main.activity_book_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookSearchActivity : AppCompatActivity() {

    private val bookAdapter = BookAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_search)

        rv_result_booksearch.adapter = bookAdapter
        setEventListener()
    }

    private fun setEventListener() {
        et_searchbox_booksearch.setOnKeyListener { _, i, keyEvent ->
            if(i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_DOWN) {
                searchBook()
            }
            return@setOnKeyListener true
        }
        btn_search_booksearch.setOnClickListener {
            searchBook()
        }
    }

    private fun searchBook() {
        val titleToSearch = et_searchbox_booksearch.text.toString()
        if(titleToSearch.isBlank()) {
            showToast("검색어를 입력해주세요.")
        } else {
            requestToServer(titleToSearch)
        }
    }

    private fun requestToServer(titleToSearch: String) {
        KakaoBookImpl.service.getBookList(
            title = titleToSearch
        ).enqueue(object : Callback<ResponseDto> {
            override fun onFailure(call: Call<ResponseDto>, t: Throwable) {
                showToast("통신 상태를 확인해주세요.")
            }

            override fun onResponse(call: Call<ResponseDto>, response: Response<ResponseDto>) {
                if(response.isSuccessful) {
                    bookAdapter.dataList = response.body()!!.documents as ArrayList<BookResponseDto>
                    bookAdapter.notifyDataSetChanged()
                } else {
                    showToast("에러 코드: ${response.code()}")
                }
            }

        })
    }
}
