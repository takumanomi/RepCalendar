package com.example.repcalendar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.repcalendar.databinding.ActivityFoodmenuBinding
import com.example.repcalendar.databinding.ActivitySizeBinding


class size : AppCompatActivity() {
    private lateinit var binding: ActivitySizeBinding
    private var text: String? = null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySizeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        text = intent?.getStringExtra("TEXT_KEY")//前の画面から送られてきた値を受け取るための定数
                when (text)  {
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



        fun onSizeButtonTapped(view: View?) { //numberへ送る？？
            var intent = Intent(this, number::class.java)//画面を遷移
            when (view?.id) {
                R.id.buttonS -> {
                    val size = "S"
                    var state = DataState(text!!,size,0)
                    intent.putExtra(number.KEY_STATE,state)//”TEXT＿KEY”＝値を送るための鍵

                }
                R.id.buttonM -> {
                    val size = "M"
                    var state = DataState(text!!, size,0)
                    intent.putExtra(number.KEY_STATE,state)
                }
                R.id.buttonL -> {
                    val size = "L"
                    var state = DataState(text!!,size,0)
                    intent.putExtra(number.KEY_STATE,state)
                }
                R.id.buttonLL -> {
                    val size = "LL"
                    var state = DataState(text!!,size,0)
                    intent.putExtra(number.KEY_STATE,state)
                }
            }
            startActivity(intent)

        }

        binding.buttonS.setOnClickListener {onSizeButtonTapped(it)}
        binding.buttonM.setOnClickListener {onSizeButtonTapped(it)}
        binding.buttonL.setOnClickListener {onSizeButtonTapped(it)}
        binding.buttonLL.setOnClickListener {onSizeButtonTapped(it)}




    }
}