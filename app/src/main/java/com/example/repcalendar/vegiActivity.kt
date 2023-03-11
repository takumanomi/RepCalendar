package com.example.repcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repcalendar.databinding.ActivitySizeBinding
import com.example.repcalendar.databinding.ActivityVegiBinding

class vegiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVegiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVegiBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_vegi)
        val text = intent.getStringExtra("TEXT_KEY")//前の画面から送られてきた値を受け取るための定数
    }


}



