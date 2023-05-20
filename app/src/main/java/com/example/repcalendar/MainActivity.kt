package com.example.repcalendar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.repcalendar.databinding.ActivityMainBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.Sort


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mCalendarAdapter: CalendarAdapter? = null
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Realmデータベースとの接続を開く
        val config = RealmConfiguration.create(schema = setOf(Realmfile::class))
        realm = Realm.open(config)

        val name = realm.query<Realmfile>().sort("date", Sort.DESCENDING).find()

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
    override fun onDestroy() {
        super.onDestroy()

        // Realmデータベースとの接続を閉じる
        realm.close()
    }
}

