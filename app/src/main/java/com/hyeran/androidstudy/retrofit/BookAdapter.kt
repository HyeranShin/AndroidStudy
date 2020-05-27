package com.hyeran.androidstudy.retrofit

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyeran.androidstudy.R

class BookAdapter(private val context: Context) : RecyclerView.Adapter<BookViewHolder>() {
    var dataList = ArrayList<BookResponseDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.btn_detailurl.setOnClickListener {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(dataList[position].url)))
        }
    }
}