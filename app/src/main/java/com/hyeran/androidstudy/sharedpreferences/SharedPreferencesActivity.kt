package com.hyeran.androidstudy.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.hyeran.androidstudy.R
import com.hyeran.androidstudy.extension_function.showToast
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        et_name_sharedpreferences.setOnKeyListener { _, i, keyEvent ->
            if (i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_DOWN) {
                saveName(et_name_sharedpreferences.text.toString())
            }
            return@setOnKeyListener true
        }

        btn_save_sharedpreferences.setOnClickListener {
            val input = et_name_sharedpreferences.text.toString()
            saveName(input)
        }

        btn_read_sharedpreferences.setOnClickListener {
            val savedName = SharedPreferencesController.getString(this, SharedPreferencesController.KEY_NAME)
            if(savedName.isNullOrBlank()) {
                tv_name_sharedpreferences.text = null
                showToast("저장된 데이터가 없습니다.")
            } else {
                tv_name_sharedpreferences.text = savedName
            }
        }

        btn_clear_sharedpreferences.setOnClickListener {
            SharedPreferencesController.clearAll(this)
            showToast("데이터 초기화")
        }
    }

    private fun saveName(name: String) {
        if(name.isBlank()) {
            showToast("이름을 입력해주세요.")
        } else {
            SharedPreferencesController.saveString(this, SharedPreferencesController.KEY_NAME, name)
            et_name_sharedpreferences.text.clear()
            showToast("$name 저장 완료")
        }
    }
}
