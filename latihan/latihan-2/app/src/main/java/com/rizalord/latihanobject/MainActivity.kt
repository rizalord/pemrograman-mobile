package com.rizalord.latihanobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    private lateinit var imgButton : ImageButton
    private lateinit var radioGroup : RadioGroup
    private lateinit var toggleButton : ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgButton = findViewById(R.id.btnImage)
        radioGroup = findViewById(R.id.rg)
        toggleButton = findViewById(R.id.tglBtn)

        imgButton.setOnClickListener {
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        }
        
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(this@MainActivity, "Anda memilih: " + radio.text, Toast.LENGTH_SHORT).show()
        }

        toggleButton.setOnClickListener {
            val status = if (toggleButton.isChecked) "Aktif" else "Tidak Aktif"
            Toast.makeText(this, "Status: " + status, Toast.LENGTH_SHORT).show()
        }
    }
}