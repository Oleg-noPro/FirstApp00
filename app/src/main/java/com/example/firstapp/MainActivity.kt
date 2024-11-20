package com.example.firstapp

import android.inputmethodservice.ExtractEditText
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextET: EditText
    private lateinit var textTV: TextView
    private lateinit var textLength: TextView
    private lateinit var buttonBN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextET = findViewById(R.id.editTextET)
        textTV = findViewById(R.id.textTV)
        buttonBN = findViewById(R.id.buttonBN)
        textLength = findViewById(R.id.textLength)

        onButtonClick(buttonBN)
    }
    fun onButtonClick(view: View) {
        val sendText = editTextET.text.reversed()
        textTV.text = sendText
        fun lengthText(input: String) {
            val sendLength = input.replace(" ", "").length.toString()
            textLength.text = sendLength
        }
        lengthText(sendText.toString())
    }


}