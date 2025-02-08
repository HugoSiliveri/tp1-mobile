package com.example.tp1

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.ComponentActivity

class FormJava : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutVertical = LinearLayout(this)
        layoutVertical.orientation = LinearLayout.VERTICAL

        val editTextFirstName = EditText(this)
        val layoutParams1 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams1.setMargins(0, 300, 0, 0)
        editTextFirstName.layoutParams = layoutParams1
        editTextFirstName.id = R.id.editTextFirstName
        editTextFirstName.hint = getString(R.string.first_name)
        editTextFirstName.inputType = InputType.TYPE_CLASS_TEXT

        val editTextLastName = EditText(this)
        val layoutParams2 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        editTextLastName.layoutParams = layoutParams2
        editTextLastName.id = R.id.editTextLastName
        editTextLastName.hint = getString(R.string.last_name)
        editTextLastName.inputType = InputType.TYPE_CLASS_TEXT

        val editTextAge = EditText(this)
        editTextAge.layoutParams = layoutParams2
        editTextAge.id = R.id.editTextAge
        editTextAge.hint = getString(R.string.age)
        editTextAge.inputType = InputType.TYPE_CLASS_NUMBER

        val editTextExpertise = EditText(this)
        editTextExpertise.layoutParams = layoutParams2
        editTextExpertise.id = R.id.editTextExpertise
        editTextExpertise.hint = getString(R.string.area_of_expertise)
        editTextExpertise.inputType = InputType.TYPE_CLASS_TEXT

        val editTextPhone = EditText(this)
        editTextPhone.layoutParams = layoutParams2
        editTextPhone.id = R.id.editTextPhone
        editTextPhone.hint = getString(R.string.phone_number)
        editTextPhone.inputType = InputType.TYPE_CLASS_PHONE

        val buttonSave = Button(this)
        buttonSave.layoutParams = layoutParams2
        buttonSave.id = R.id.buttonSave
        buttonSave.text = getString(R.string.save)


        layoutVertical.addView(editTextFirstName)
        layoutVertical.addView(editTextLastName)
        layoutVertical.addView(editTextAge)
        layoutVertical.addView(editTextExpertise)
        layoutVertical.addView(editTextPhone)
        layoutVertical.addView(buttonSave)
        setContentView(layoutVertical)
    }
}
