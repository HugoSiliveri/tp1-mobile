package com.example.tp1

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class Form : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val editTextExpertise = findViewById<EditText>(R.id.editTextExpertise)
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_text))
                .setMessage(getString(R.string.dialog_message))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val firstName = editTextFirstName.text.toString()
                    val lastName = editTextLastName.text.toString()
                    val age = editTextAge.text.toString()
                    val expertise = editTextExpertise.text.toString()
                    val phone = editTextPhone.text.toString()

                    val intent = Intent(this, FormResult::class.java).apply {
                        putExtra("FIRST_NAME", firstName)
                        putExtra("LAST_NAME", lastName)
                        putExtra("AGE", age)
                        putExtra("EXPERTISE", expertise)
                        putExtra("PHONE", phone)
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
