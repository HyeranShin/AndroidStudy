package com.hyeran.androidstudy.lifecycle.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.androidstudy.R

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
    }
}
