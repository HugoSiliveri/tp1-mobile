package com.example.tp1

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class TrainResult : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val start = intent.getStringExtra("START")
        val end = intent.getStringExtra("END")
        val date = intent.getStringExtra("DATE")

        val random = Random

        val layoutVertical = LinearLayout(this)
        layoutVertical.orientation = LinearLayout.VERTICAL
        layoutVertical.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val scrollView = ScrollView(this)
        scrollView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val nbElem = random.nextInt(1, 8)
        for (i in 0..nbElem) {

            val layoutVertical2 = LinearLayout(this)
            layoutVertical2.orientation = LinearLayout.VERTICAL
            layoutVertical2.setBackgroundResource(R.drawable.border)
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            when (i) {
                0 -> layoutParams.setMargins(40,300,40,30)
                nbElem -> layoutParams.setMargins(40,0,40,0)
                else -> layoutParams.setMargins(40,0,40,30)
            }
            layoutVertical2.layoutParams = layoutParams

            val layoutVertical3 = LinearLayout(this)
            layoutVertical3.orientation = LinearLayout.VERTICAL
            val layoutParams2 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams2.setMargins(50, 50, 50, 15)
            layoutVertical3.layoutParams = layoutParams2


            val layoutHorizontal = LinearLayout(this)
            layoutHorizontal.orientation = LinearLayout.HORIZONTAL
            val layoutHorizontal2 = LinearLayout(this)
            layoutHorizontal2.orientation = LinearLayout.HORIZONTAL
            val layoutHorizontal3 = LinearLayout(this)
            layoutHorizontal3.orientation = LinearLayout.HORIZONTAL

            val layoutHorizontal4 = LinearLayout(this)
            layoutHorizontal4.orientation = LinearLayout.HORIZONTAL
            val layoutParams3 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams3.setMargins(50, 15, 50, 50)
            layoutHorizontal4.layoutParams = layoutParams3

            val layoutHorizontal5 = LinearLayout(this)
            layoutHorizontal5.orientation = LinearLayout.HORIZONTAL
            val layoutParams4 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams4.gravity = Gravity.CENTER
            layoutHorizontal5.layoutParams = layoutParams4


            val startHour = random.nextInt(6, 22)
            val startMinute = random.nextInt(0, 60)
            val departureTime = String.format("%02d:%02d", startHour, startMinute)

            val duration = random.nextInt(30, 180)
            val arrivalHour = (startHour * 60 + startMinute + duration) / 60
            val arrivalMinute = (startHour * 60 + startMinute + duration) % 60
            val arrivalTime = String.format("%02d:%02d", arrivalHour, arrivalMinute)

            val totalMinutes = (arrivalHour * 60 + arrivalMinute) - (startHour * 60 + startMinute)
            val travelHours = totalMinutes / 60
            val travelMinutes = totalMinutes % 60
            val travelDuration = if (travelHours > 0) {
                "$travelHours h $travelMinutes min"
            } else {
                "$travelMinutes min"
            }

            val layoutParams8 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams8.setMargins(0, 0, 20, 0)

            val textViewDepartureTime = TextView(this)
            textViewDepartureTime.layoutParams = layoutParams8
            textViewDepartureTime.text = departureTime
            textViewDepartureTime.setTextColor(Color.parseColor("#000000"))
            textViewDepartureTime.setTypeface(null, Typeface.BOLD)
            textViewDepartureTime.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            val textViewArrivalTime = TextView(this)
            textViewArrivalTime.layoutParams = layoutParams8
            textViewArrivalTime.text = arrivalTime
            textViewArrivalTime.setTextColor(Color.parseColor("#000000"))
            textViewArrivalTime.setTypeface(null, Typeface.BOLD)
            textViewArrivalTime.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            val layoutParams9 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams9.setMargins(0, 0, 200, 0)

            val textViewStart = TextView(this)
            textViewStart.layoutParams = layoutParams9
            textViewStart.text = start
            textViewStart.setTextColor(Color.parseColor("#000000"))
            textViewStart.setTypeface(null, Typeface.BOLD)
            textViewStart.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            val textViewEnd = TextView(this)
            textViewEnd.layoutParams = layoutParams9
            textViewEnd.text = end
            textViewEnd.setTextColor(Color.parseColor("#000000"))
            textViewEnd.setTypeface(null, Typeface.BOLD)
            textViewEnd.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            val layoutParams10 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            val textViewPrice = TextView(this)
            textViewPrice.layoutParams = layoutParams10
            textViewPrice.text = (0..100).random().toString() + "€"
            textViewPrice.setTextColor(Color.parseColor("#000000"))
            textViewPrice.setTypeface(null, Typeface.BOLD)
            textViewPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            val layoutParams11 = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )
            val textViewDuration = TextView(this)
            textViewDuration.layoutParams = layoutParams11
            textViewDuration.text = travelDuration
            textViewDuration.setTypeface(null, Typeface.BOLD)
            textViewDuration.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)

            val textViewDate = TextView(this)
            textViewDate.layoutParams = layoutParams11
            textViewDate.text = date
            textViewDate.setTypeface(null, Typeface.BOLD)
            textViewDate.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)


            layoutHorizontal2.addView(textViewDepartureTime)
            layoutHorizontal2.addView(textViewStart)
            layoutHorizontal3.addView(textViewArrivalTime)
            layoutHorizontal3.addView(textViewEnd)
            layoutVertical3.addView(layoutHorizontal2)
            layoutVertical3.addView(layoutHorizontal3)

            layoutHorizontal5.addView(textViewPrice)
            layoutHorizontal.addView(layoutVertical3)
            layoutHorizontal.addView(layoutHorizontal5)

            layoutHorizontal4.addView(textViewDuration)
            layoutHorizontal4.addView(textViewDate)
            layoutVertical2.addView(layoutHorizontal)
            layoutVertical2.addView(layoutHorizontal4)

            layoutVertical.addView(layoutVertical2)
        }
        scrollView.addView(layoutVertical)
        setContentView(scrollView)
    }
}