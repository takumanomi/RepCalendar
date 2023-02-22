package com.example.repcalendar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.repcalendar.databinding.ActivityFoodmenuBinding

class Foodmenu : AppCompatActivity() {
    private lateinit var binding: ActivityFoodmenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clicketButton.setOnClickListener {onFoodButtonTapped(it)}
        binding.cockloachButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.mouseButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.pinkmouseButton.setOnClickListener{onFoodButtonTapped(it)}

    }
    fun onFoodButtonTapped(view: View?) {
        var intent = Intent(this, size::class.java)//画面を遷移
        when (view?.id) {
            R.id.clicketButton -> {
                val text = "clicket"
                intent.putExtra("TEXT_KEY",text)//”TEXT＿KEY”＝値を送るための鍵
                //putExtraで値（「選択したのはコオロギである」）を送る
            }
            R.id.cockloachButton -> {
                val text = "cockloach"
                intent.putExtra("TEXT_KEY",text)
            }
            R.id.mouseButton -> {
                val text = "mouse"
                intent.putExtra("TEXT_KEY",text)
            }
            R.id.pinkmouseButton -> {
                val text = "pinkmouse"
                intent.putExtra("TEXT_KEY",text)
            }
            R.id.wormButton -> {
                val text = "warm"
                intent.putExtra("TEXT_KEY",text)
            }
            //intent = Intent(this,vegiActivity::class.java)


        }
        startActivity(intent)
    }
}

