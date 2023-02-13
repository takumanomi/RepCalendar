package com.example.repcalendar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.repcalendar.databinding.ActivityFoodmenuBinding
import com.example.repcalendar.databinding.ActivityMainBinding

class Foodmenu : AppCompatActivity() {
    private lateinit var binding: ActivityFoodmenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodmenu)



        fun onFoodButtonTapped(ciew: View?) {
            val intent = Intent(this, size::class.java)
            startActivity(intent)
        }
        binding.clicketButton.setOnClickListener {onFoodButtonTapped(it)}
        binding.cockloachButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.mouseButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.pinkmouseButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.gelButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.vegiButton.setOnClickListener{onFoodButtonTapped(it)}
        binding.wormButton.setOnClickListener{onFoodButtonTapped(it)}


    }
}
