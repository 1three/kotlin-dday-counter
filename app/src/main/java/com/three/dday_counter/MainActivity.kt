package com.three.dday_counter

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.startBtn)
        val endBtn: Button = findViewById(R.id.endBtn)

        var startDate = ""
        var endDate = ""

        val calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        startBtn.setOnClickListener {
            // 오늘 날짜 가져오기
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    startDate = "${year}/${month + 1}/${dayOfMonth}"
                    startBtn.setText(startDate)
                    calendar_start.set(year, month + 1, dayOfMonth)
                }
            }, year, month, date)

            dlg.show()
        }

        endBtn.setOnClickListener {
            // 오늘 날짜 가져오기
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    endDate = "${year}/${month + 1}/${dayOfMonth}"
                    endBtn.setText(endDate)
                    calendar_end.set(year, month + 1, dayOfMonth)

                    val calcDate =
                        TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                    val dDayText = findViewById<TextView>(R.id.dDayTextView)

                    if (calcDate.toInt() == 0) {
                        dDayText.text = "D-Day"
                    } else if (calcDate.toInt() > 0) {
                        dDayText.text = "D-${calcDate}"
                    } else {
                        dDayText.text = "시작 일자를\n변경해 주세요."
                    }
                }
            }, year, month, date)

            dlg.show()
        }
    }
}