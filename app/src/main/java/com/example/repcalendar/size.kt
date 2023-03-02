package com.example.repcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.repcalendar.databinding.ActivityFoodmenuBinding
import com.example.repcalendar.databinding.ActivitySizeBinding


class size : AppCompatActivity() {
    private lateinit var binding: ActivitySizeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySizeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        fun onSizeButtonTapped(view: View?) {
            var intent = Intent(this, number::class.java)//画面を遷移
            when (view?.id) {
                R.id.buttonS -> {
                    val text = "S"
                    intent.putExtra("TEXT_KEY", text)//”TEXT＿KEY”＝値を送るための鍵
                }
                R.id.buttonM -> {
                    val text = "M"
                    intent.putExtra("TEXT_KEY", text)
                }
                R.id.buttonL -> {
                    val text = "L"
                    intent.putExtra("TEXT_KEY", text)
                }
                R.id.buttonLL -> {
                    val text = "LL"
                    intent.putExtra("TEXT_KEY", text)
                }
            }
        }

        binding.buttonS.setOnClickListener {onSizeButtonTapped(it)}
        binding.buttonM.setOnClickListener {onSizeButtonTapped(it)}
        binding.buttonL.setOnClickListener {onSizeButtonTapped(it)}
        binding.buttonLL.setOnClickListener {onSizeButtonTapped(it)}


        val text = intent.getStringExtra("TEXT_KEY")//前の画面から送られてきた値を受け取るための定数
        when (text) {
            "clicket" -> {
                binding.image.setImageResource(R.drawable.clicket)
            }
            "cockloach" -> {
                binding.image.setImageResource(R.drawable.cockroach)
            }
            "mouse" -> {
                binding.image.setImageResource(R.drawable.mouse)
            }
            "pinkmouse" -> {
                binding.image.setImageResource(R.drawable.pinkmouse)
            }
            "worm" -> {
                binding.image.setImageResource(R.drawable.worm)
            }
        }

    }
}