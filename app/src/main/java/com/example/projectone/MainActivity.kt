package com.example.projectone

import android.content.ClipData.newIntent
import android.content.Intent
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

        submitButton = findViewById(R.id.submit_button)
        editText = findViewById(R.id.editTextIngredient)

        submitButton.setOnClickListener {
            val myText = editText.text.toString()
            if (myText == "") {
                Toast.makeText(this, R.string.instruction_Toast, Toast.LENGTH_SHORT).show()

            } else {
                // Start RecipeShower Activity
                val intent = RecipeShower.newIntent(this@MainActivity, myText)
                startActivity(intent)
            }

        }
    }
}