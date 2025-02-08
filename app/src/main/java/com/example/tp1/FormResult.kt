package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity


class FormResult : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_result)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val age = intent.getStringExtra("AGE")
        val expertise = intent.getStringExtra("EXPERTISE")
        val phone = intent.getStringExtra("PHONE")

        val textViewFirstName = findViewById<TextView>(R.id.textViewFirstName)
        val textViewLastName = findViewById<TextView>(R.id.textViewLastName)
        val textViewAge = findViewById<TextView>(R.id.textViewAge)
        val textViewExpertise = findViewById<TextView>(R.id.textViewExpertise)
        val textViewPhone = findViewById<TextView>(R.id.textViewPhoneNumber2)

        val fn : String = getString(R.string.first_name_result)
        textViewFirstName.text = "$fn $firstName"

        val ln : String = getString(R.string.last_name_result)
        textViewLastName.text = "$ln $lastName"

        val a : String = getString(R.string.age_result)
        textViewAge.text = "$a $age"

        val e : String = getString(R.string.area_of_expertise_result)
        textViewExpertise.text = "$e $expertise"

        val p : String = getString(R.string.phone_number_result)
        textViewPhone.text = "$p $phone"

        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            val intent = Intent(this, Form::class.java)
            startActivity(intent)
        }
        
        val buttonNext = findViewById<Button>(R.id.buttonNext)
        buttonNext.setOnClickListener {
            val intent2 = Intent(this, Phone::class.java).apply {
                putExtra("PHONE", phone)
            }
            startActivity(intent2)
        }
    }
}