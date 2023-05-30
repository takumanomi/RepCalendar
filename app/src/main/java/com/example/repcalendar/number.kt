package com.example.repcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.repcalendar.databinding.ActivityFoodmenuBinding
import com.example.repcalendar.databinding.ActivityNumberBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query

class number : AppCompatActivity() {
    private lateinit var realm: Realm
    private lateinit var binding: ActivityNumberBinding

    companion object {
        val KEY_STATE = "key_state"
    }

    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val config = RealmConfiguration.create(schema = setOf(Realmfile::class))
        realm = Realm.open(config) //realmの初期化

        binding.imageButton1.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton2.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton3.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton4.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton5.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton6.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton7.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton8.setOnClickListener {onNumberButtonTapped(it)}
        binding.imageButton9.setOnClickListener {onNumberButtonTapped(it)}


    }



    fun onNumberButtonTapped(view: View) {

        when (view?.id) {
            R.id.imageButton1 -> {
                number = 1
            }
            R.id.imageButton2 -> {
                number = 2
            }
            R.id.imageButton3 -> {
                number = 3
            }
            R.id.imageButton4 -> {
                number = 4
            }
            R.id.imageButton5 -> {
                number = 5
            }
            R.id.imageButton6 -> {
                number = 6
            }
            R.id.imageButton7 -> {
                number = 7
            }
            R.id.imageButton8 -> {
                number = 8
            }
            R.id.imageButton9 -> {
                number = 9
            }
        }
        val state = intent.getSerializableExtra(KEY_STATE)

        if(state is DataState){
            var data = DataState(state.name,state.size,number)
            realm.writeBlocking {
                copyToRealm(Realmfile().apply {
                    // 最大のid+1をセット
                    id = (realm.query<Realmfile>().max("id", Int::class).find() ?: -1) + 1
                    name = data.name
                    size = data.size
                    number = data.number
                })
            }
        }
        var intent = Intent(this, com.example.repcalendar.MainActivity::class.java)//画面を遷移
        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        // Realmデータベースとの接続を閉じる
        realm.close()

    }



}