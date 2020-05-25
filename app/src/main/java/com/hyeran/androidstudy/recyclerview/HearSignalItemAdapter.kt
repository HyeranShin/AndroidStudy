package com.hyeran.androidstudy.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyeran.androidstudy.R

/** 데이터 리스트 중 하나 전달 **/
class HearSignalItemAdapter(private val context: Context) : RecyclerView.Adapter<HearSignalItemViewHolder>() {
    var dataList = mutableListOf<HearSignalData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HearSignalItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_heartsignal, parent, false)
        return HearSignalItemViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HearSignalItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}