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



        fun onFoodButtonTapped(view: View?) {
            val intent = Intent(this, size::class.java)
            startActivity(intent)

        }
        binding.clicketButton.setOnClickListener {onFoodButtonTapped(it)}
        binding.cockloachButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.mouseButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.pinkmouseButton.setOnClickListener{onFoodButtonTapped(it)}


    }
}
