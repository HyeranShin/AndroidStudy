package com.hyeran.androidstudy.lifecycle.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hyeran.androidstudy.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /**
     * 처음 화면 들어오면
     * onCreate → onStart → onResume
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("=====>", " Activity Life Cycle: onCreate")
        setContentView(R.layout.activity_main)

        btn_next_main.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
            /**
             * Next Activity로 이동
             * onPause → onStop
             * 돌아오면
             * onRestart → onStart → onResume
             */
        }
        btn_finish_next_main.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
            finish()
            /**
             * Next Activity로 이동 후 finish()
             * onPause → onStop → onDestory
             */
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("=====>", " Activity Life Cycle: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("=====>", " Activity Life Cycle: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("=====>", " Activity Life Cycle: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("=====>", " Activity Life Cycle: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("=====>", " Activity Life Cycle: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("=====>", " Activity Life Cycle: onDestroy")
    }
}
