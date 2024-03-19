package com.example.latihan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnContoh: Button
    private lateinit var btnLatihan1: Button
    private lateinit var btnLatihan2: Button
    private lateinit var btnLatihan3: Button
    private lateinit var btnLatihan4: Button
    private lateinit var btnLatihan5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContoh = findViewById(R.id.contoh)
        btnLatihan1 = findViewById(R.id.latihan1)
        btnLatihan2 = findViewById(R.id.latihan2)
        btnLatihan3 = findViewById(R.id.latihan3)
        btnLatihan4 = findViewById(R.id.latihan4)
        btnLatihan5 = findViewById(R.id.latihan5)

        btnContoh.setOnClickListener {
            startActivity(Intent(this, Contoh::class.java))
        }

        btnLatihan1.setOnClickListener {
            startActivity(Intent(this, Latihan1::class.java))
        }

        btnLatihan2.setOnClickListener {
            startActivity(Intent(this, Latihan2::class.java))
        }

        btnLatihan3.setOnClickListener {
            startActivity(Intent(this, Latihan3::class.java))
        }

        btnLatihan4.setOnClickListener {
            startActivity(Intent(this, Latihan4::class.java))
        }

        btnLatihan5.setOnClickListener {
            startActivity(Intent(this, Latihan5::class.java))
        }
    }
}