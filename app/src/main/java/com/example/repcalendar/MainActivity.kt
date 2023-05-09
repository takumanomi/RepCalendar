package com.example.repcalendar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.repcalendar.databinding.ActivityMainBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.query.RealmResults


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mCalendarAdapter: CalendarAdapter? = null
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // items in the realm whose name begins with the letter 'D'
        val itemsThatBeginWIthD: RealmResults<Realmfile> =
            realm.query<Realmfile>("name")
                .find()

        val size: RealmResults<Realmfile> =
            realm.query<Realmfile>("size")
                .find()

        val number: RealmResults<Realmfile> =
            realm.query<Realmfile>("number")
                .find()


        // all items in the realm
        //val name: RealmResults<Realmfile> = realm.query<Realmfile>("name").find()
        //val size: RealmResults<Realmfile> = realm.query<Realmfile>("size").find()

        realm.close()

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

