package com.example.repcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query

class number : AppCompatActivity() {
    private lateinit var realm: Realm

    companion object {
        val KEY_STATE = "key_state"
    }

    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = RealmConfiguration.create(schema = setOf(Realmfile::class))
        realm = Realm.open(config) //realmの初期化
        setContentView(R.layout.activity_number)

    }



    fun onNumberButtonTapped(view: View) {

        when (view?.id) {
            R.id.secretbutton1 -> {
                number = 1
            }
            R.id.secretbutton2 -> {
                number = 2
            }
            R.id.secretbutton3 -> {
                number = 3
            }
            R.id.secretbutton4 -> {
                number = 4
            }
            R.id.secretbutton5 -> {
                number = 5
            }
            R.id.secretbutton6 -> {
                number = 6
            }
            R.id.secretbutton7 -> {
                number = 7
            }
            R.id.secretbutton8 -> {
                number = 8
            }
            R.id.secretbutton9 -> {
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

        startActivity(intent)
        var intent = Intent(this, com.example.repcalendar.MainActivity::class.java)//画面を遷移
    }
    override fun onDestroy() {
        super.onDestroy()

        // Realmデータベースとの接続を閉じる
        realm.close()
    }


}