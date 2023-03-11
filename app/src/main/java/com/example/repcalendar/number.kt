package com.example.repcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class number : AppCompatActivity() ,View.OnClickListener {

    companion object {
        val KEY_STATE = "key_state"
    }

    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        val intent: Intent = Intent(this,MainActivity().javaClass)
        startActivity(intent)
    }

    override fun onClick(view: View) {
        when (view.id) {
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
    }

            // ここへボタンクリック時の処理を書く
                // ・・・
    //fun resultnumber
    //when {
       // R.id.secretbutton1 -> "1"
        //R.id.secretbutton2 -> "2"
        //R.id.secretbutton3 -> "3"
        //R.id.secretbutton4 -> "4"
        //R.id.secretbutton5 -> "5"
        //R.id.secretbutton6 -> "6"
        //R.id.secretbutton7 -> "7"
        //R.id.secretbutton8 -> "8"
       // R.id.secretbutton9 -> "9"
    //}
}