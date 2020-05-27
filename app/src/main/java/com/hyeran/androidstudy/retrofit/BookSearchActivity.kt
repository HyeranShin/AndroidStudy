package com.hyeran.androidstudy.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.hyeran.androidstudy.R
import com.hyeran.androidstudy.extension_function.customEnqueue
import com.hyeran.androidstudy.extension_function.showToast
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
            if (i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_DOWN) {
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
        if (titleToSearch.isBlank()) {
            showToast("검색어를 입력해주세요.")
        } else {
            requestToServer(titleToSearch)
        }
    }

    private fun requestToServer(titleToSearch: String) {
        KakaoBookImpl.service.getBookList(
            title = titleToSearch
        ).customEnqueue(
            onFail = { showToast(it) },
            onSuccess = {
                bookAdapter.dataList = it.documents as ArrayList<BookResponseDto>
                bookAdapter.notifyDataSetChanged()
            },
            onError = { showToast(it) }
        )
        /** 확장함수 안썼을 떄 **/
//            .enqueue(object : Callback<ResponseDto> {
//                override fun onFailure(call: Call<ResponseDto>, t: Throwable) {
//
//                }
//
//                override fun onResponse(call: Call<ResponseDto>, response: Response<ResponseDto>) {
//                    if (response.isSuccessful) {
//
//                    } else {
//                        showToast("에러 코드: ${response.code()}")
//                    }
//                }
//
//            })
    }
}
