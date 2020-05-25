package com.hyeran.androidstudy.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyeran.androidstudy.R

/** 데이터와 뷰 연결 **/
class HearSignalItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val iv_profile = itemView.findViewById<ImageView>(R.id.iv_profile_item_rv_heartsignal)
    val tv_name = itemView.findViewById<TextView>(R.id.tv_name_item_rv_hearsignal)
    val tv_sns = itemView.findViewById<TextView>(R.id.tv_sns_item_rv_hearsignal)

    fun bind(hearSignalData: HearSignalData) {
        Glide.with(itemView).load(hearSignalData.profile).into(iv_profile)
        tv_name.text = hearSignalData.name
        tv_sns.text = '@'+hearSignalData.sns
    }
}