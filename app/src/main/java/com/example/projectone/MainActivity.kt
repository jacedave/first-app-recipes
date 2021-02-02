package com.example.projectone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var submitButton: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myText = R.string.instructions_main

        submitButton = findViewById(R.id.submit_button)
        editText = findViewById(R.id.editTextIngredient)

        editText.setOnClickListener {
            editText.setText("")
        }

        submitButton.setOnClickListener {
            val messageResId = when {
                myText == R.string.instructions_main -> R.string.instruction_Toast
                else -> R.string.instruction_Toast
            }

            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                    .show()
        }
    }
}