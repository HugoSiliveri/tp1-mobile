package com.example.tp1

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setLocale("fr", this)

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

        val buttonFormJava = findViewById<Button>(R.id.buttonFormJava)
        buttonFormJava.setOnClickListener {
            val intent3 = Intent(this, FormJava::class.java)
            startActivity(intent3)
        }

        val buttonTrain = findViewById<Button>(R.id.buttonTrain)
        buttonTrain.setOnClickListener {
            val intent4 = Intent(this, Train::class.java)
            startActivity(intent4)
        }
    }

    /**
     * Fonction qui permet de changer la langue
     */
    fun setLocale(lang: String, context: Context) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}