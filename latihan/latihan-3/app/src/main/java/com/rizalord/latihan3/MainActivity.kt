package com.rizalord.latihan3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var imgButton: ImageButton
    private lateinit var radioGroup: RadioGroup
    private lateinit var toggleButton: ToggleButton
    private lateinit var btnIntent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imgButton = findViewById(R.id.btnImage)
        radioGroup = findViewById(R.id.rg)
        toggleButton = findViewById(R.id.tglBtn)
        btnIntent = findViewById(R.id.btnIntent)

        imgButton.setOnClickListener {
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(this@MainActivity, "Anda memilih: " + radio.text, Toast.LENGTH_SHORT)
                .show()
        }

        toggleButton.setOnClickListener {
            val status = if (toggleButton.isChecked) "Aktif" else "Tidak Aktif"
            Toast.makeText(this, "Status: " + status, Toast.LENGTH_SHORT).show()
        }

        btnIntent.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


    }
}