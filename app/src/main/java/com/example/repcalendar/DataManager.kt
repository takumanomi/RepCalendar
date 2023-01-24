import java.text.SimpleDateFormat
import java.util.*

class DateManager {
    var mCalendar: Calendar = Calendar.getInstance()

    val days: List<Any>
        get() {
            //現在の状態を保持
            val startDate: Date = mCalendar.time

            //GridViewに表示するマスの合計を計算
            val count = weeks * 7

            //当月のカレンダーに表示される前月分の日数を計算
            mCalendar.set(Calendar.DATE, 1)
            val dayOfWeek: Int = mCalendar.get(Calendar.DAY_OF_WEEK) - 1
            mCalendar.add(Calendar.DATE, -dayOfWeek)
            val days: MutableList<Date> = ArrayList()
            for (i in 0 until count) {
                days.add(mCalendar.time)
                mCalendar.add(Calendar.DATE, 1)
            }

            //状態を復元
            mCalendar.time = startDate
            return days
        }

    //当月かどうか確認
    fun isCurrentMonth(date: Any): Boolean {
        val format = SimpleDateFormat("yyyy.MM", Locale.US)
        val currentMonth: String = format.format(mCalendar.time)
        return currentMonth == date.let { format.format(it) }
    }

    //週数を取得
    val weeks: Int
        get() = mCalendar.getActualMaximum(Calendar.WEEK_OF_MONTH)

    //曜日を取得
    fun getDayOfWeek(date: Any): Int {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = date as Date
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    //翌月へ
    fun nextMonth() {
        mCalendar.add(Calendar.MONTH, 1)
    }

    //前月へ
    fun prevMonth() {
        mCalendar.add(Calendar.MONTH, -1)
    }
}