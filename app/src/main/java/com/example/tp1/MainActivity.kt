package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonHelloWorld = findViewById<Button>(R.id.buttonHelloWorld)
        buttonHelloWorld.setOnClickListener {
            val intent = Intent(this, HelloWorld::class.java)
            startActivity(intent)
        }

        val buttonForm = findViewById<Button>(R.id.buttonForm)
        buttonForm.setOnClickListener {
            val intent2 = Intent(this, Form::class.java)
            startActivity(intent2)
        }
    }
}