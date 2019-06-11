package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 隐藏标题
        val actionBar = supportActionBar
        actionBar!!.hide()

        // 丸暗記
        btnLearn.setOnClickListener{
            val intent = Intent(this, LearnActivity::class.java)
            startActivity(intent)
        }

        // テスト
        btnTest.setOnClickListener{
            Toast.makeText(applicationContext, "未実装", Toast.LENGTH_LONG).show()
        }
    }
}
