package com.example.tp1

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Calendar : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val editTextEvent = findViewById<EditText>(R.id.editTextEvent)
        val buttonAddEvent = findViewById<Button>(R.id.buttonAddEvent)

        val selectedDateMillis = calendarView.date
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        var selectedDate = dateFormat.format(Date(selectedDateMillis))

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        }

        buttonAddEvent.setOnClickListener {
            val textViewEvent = TextView(this)
            textViewEvent.text = "$selectedDate : ${editTextEvent.text}"
            editTextEvent.text.clear()

            linearLayout.addView(textViewEvent)
        }
    }
}
