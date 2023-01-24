package com.example.repcalendar

import DateManager
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarAdapter(context: Context) : BaseAdapter() {
    private var dateArray: List<Any> = ArrayList()
    private val mContext: Context
    private val mDateManager: DateManager
    private val mLayoutInflater: LayoutInflater

    // リスナを格納する変数を定義（lateinitで初期化を遅らせている）
    private lateinit var listener: OnBookCellClickListener

    // インターフェースを作成
    interface  OnBookCellClickListener {
        fun onItemClick()
    }// リスナーをセット
    fun setOnBookCellClickListener(listener: OnBookCellClickListener) {
        // 定義した変数listenerに実行したい処理を引数で渡す（BookListFragmentで渡している）
        this.listener = listener
    }


    //カスタムセルを拡張したらここでWigetを定義
    private class ViewHolder(itemView: View)  :RecyclerView.ViewHolder(itemView)  {
        var dateText: TextView? = null
    }

    init {
        mContext = context
        mLayoutInflater = LayoutInflater.from(mContext)
        mDateManager = DateManager()
        dateArray = mDateManager.days
    }

    override fun getCount(): Int {
        return dateArray.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView: View? = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.calendar_cell, null)
            holder = ViewHolder(convertView)
            holder.itemView.setOnClickListener {
                // セルがクリックされた時にインターフェースの処理が実行される
                listener.onItemClick()
            }
            //セルがクリックされた時の行動を定義
            holder.dateText = convertView.findViewById(R.id.dateText)
            convertView.setTag(holder)
        } else {
            holder = convertView.tag as ViewHolder
        }

        //セルのサイズを指定
        val dp: Float = mContext.resources.displayMetrics.density
        val params = AbsListView.LayoutParams(
            parent.width / 7 - dp.toInt(),
            (parent.height - dp.toInt() * mDateManager.weeks) / mDateManager.weeks
        )
        if (convertView != null) {
            holder.itemView.layoutParams = params
        }

        //日付のみ表示させる
        val dateFormat = SimpleDateFormat("d", Locale.US)
        holder.dateText!!.text = dateFormat.format(dateArray[position])

        //当月以外のセルをグレーアウト
        if (mDateManager.isCurrentMonth(dateArray[position])) {
            convertView?.setBackgroundColor(Color.WHITE)
        } else {
            convertView?.setBackgroundColor(Color.LTGRAY)
        }

        //日曜日を赤、土曜日を青に
        val colorId: Int
        colorId = when (mDateManager.getDayOfWeek(dateArray[position])) {
            1 -> Color.RED
            7 -> Color.BLUE
            else -> Color.BLACK
        }
        holder.dateText!!.setTextColor(colorId)
        return convertView
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    //表示月を取得
    val title: String
        get() {
            val format = SimpleDateFormat("yyyy.MM", Locale.US)
            return format.format(mDateManager.mCalendar.time)
        }

    //翌月表示
    fun nextMonth() {
        mDateManager.nextMonth()
        dateArray = mDateManager.days as List<Date>
        notifyDataSetChanged()
    }

    //前月表示
    fun prevMonth() {
        mDateManager.prevMonth()
        dateArray = mDateManager.days as List<Date>
        notifyDataSetChanged()
    }


//クリックイベントに対する専用リスナー
//リスナーは表示ボタンにイベントが発生するのを見守っている

   // override fun onClick(v: View?) {
     //   TODO("Not yet implemented"
}
