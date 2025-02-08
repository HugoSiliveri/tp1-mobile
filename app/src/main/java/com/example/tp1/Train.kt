package com.example.tp1

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import androidx.activity.ComponentActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class Train : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)

        val editTextStart = findViewById<EditText>(R.id.editTextStart)
        val editTextEnd = findViewById<EditText>(R.id.editTextEnd)

        val calendarViewTrain = findViewById<CalendarView>(R.id.calendarViewTrain)

        val selectedDateMillis = calendarViewTrain.date
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        var selectedDate = dateFormat.format(Date(selectedDateMillis))

        calendarViewTrain.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        }

        val buttonSchedules = findViewById<Button>(R.id.buttonSchedules)
        buttonSchedules.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_text))
                .setMessage(getString(R.string.dialog_message))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val start = editTextStart.text.toString()
                    val end = editTextEnd.text.toString()

                    val intent = Intent(this, TrainResult::class.java).apply {
                        putExtra("START", start)
                        putExtra("END", end)
                        putExtra("DATE", selectedDate)
                    }
                    startActivity(intent)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}
