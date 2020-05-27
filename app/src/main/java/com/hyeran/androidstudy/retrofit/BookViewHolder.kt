package com.hyeran.androidstudy.retrofit

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyeran.androidstudy.R

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val iv_thumbnail = itemView.findViewById<ImageView>(R.id.iv_thumbnail_book)
    private val tv_title = itemView.findViewById<TextView>(R.id.tv_title_book)
    private val tv_author = itemView.findViewById<TextView>(R.id.tv_author_book)
    private val tv_contents = itemView.findViewById<TextView>(R.id.tv_contents_book)
    val btn_detailurl = itemView.findViewById<Button>(R.id.btn_detailurl_book)

    fun bind(responseDto: BookResponseDto) {
        Glide.with(itemView).load(responseDto.thumbnail).into(iv_thumbnail)
        tv_title.text = responseDto.title
        tv_author.text = getAuthors(responseDto.authors)
        tv_contents.text = responseDto.contents
    }

    private fun getAuthors(authorList: List<String>): String {
        var authors : String = ""
        for(author: String in authorList) {
            authors += "$author "
        }
        return authors
    }
}