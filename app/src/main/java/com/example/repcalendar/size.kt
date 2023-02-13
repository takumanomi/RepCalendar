package com.example.repcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repcalendar.databinding.ActivityFoodmenuBinding
import com.example.repcalendar.databinding.ActivitySizeBinding


class size : AppCompatActivity() {
    private lateinit var binding: ActivitySizeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySizeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra("TEXT_KEY")//前の画面から送られてきた値を受け取るための定数
        when (text) {
            "clicket" -> {
                binding.image.setImageResource(R.drawable.clicket)
            }
        }
        //val intent: Intent = Intent(this,number().javaClass)
        //startActivity(intent)
    }
}