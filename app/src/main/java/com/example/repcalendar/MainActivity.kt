package com.example.repcalendar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.repcalendar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mCalendarAdapter: CalendarAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.prevButton.setOnClickListener {
            mCalendarAdapter?.prevMonth()
            binding.titleText.text = mCalendarAdapter?.title

        }

        binding.nextButton.setOnClickListener {
            mCalendarAdapter?.nextMonth()
            binding.titleText.text = mCalendarAdapter?.title

        }
        mCalendarAdapter = CalendarAdapter(this)
        binding.calendarGridView.adapter = mCalendarAdapter
        binding.titleText.text = mCalendarAdapter?.title
        mCalendarAdapter?.setOnBookCellClickListener(
            object : CalendarAdapter.OnBookCellClickListener {
                override fun onItemClick() {
                    val intent = Intent(application, Foodmenu::class.java)
                    startActivity(intent)




                }
            }
        )

    }
}

