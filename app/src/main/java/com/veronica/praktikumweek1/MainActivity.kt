package com.veronica.praktikumweek1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnForm = findViewById<Button>(R.id.btnForm)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)

        btnToast.setOnClickListener {
            Toast.makeText(this, "Toast button click sucessfully!", Toast.LENGTH_SHORT).show()
        }

        btnForm.setOnClickListener {
            val nama = etNama.text.toString().trim()

            if (nama.isEmpty()){
                etNama.error = "Nama is required!"
                Toast.makeText(this, "Please fill in your name first!", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent (this, FormActivity::class.java)
                intent.putExtra("EXTRA_SENDER",nama)
                startActivity(intent)
            }

        btnBrowser.setOnClickListener {
            val query = "https://akprind.ac.id"
            val intent = Intent(Intent.ACTION_VIEW, query.toUri())
            startActivity(intent)
        }
        }
    }
}