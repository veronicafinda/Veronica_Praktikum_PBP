package com.veronica.praktikumweek1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val etInputMessage = findViewById<EditText>(R.id.etInputMessage)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val namaSender = intent.getStringExtra("EXTRA_SENDER")

        tvWelcome.text = getString(R.string.welcome, namaSender)

        btnSave.setOnClickListener {
            val message = etInputMessage.text.toString().trim()
            if (message.isEmpty()){
                Toast.makeText(this, "Message save: $message", Toast.LENGTH_SHORT).show()
                finish()
            }else {
                etInputMessage.error = "Message cannot be empty!"
            }

        }
    }
}