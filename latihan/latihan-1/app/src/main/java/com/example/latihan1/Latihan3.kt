package com.example.latihan1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.latihan1.databinding.ActivityLatihan3Binding

class Latihan3 : AppCompatActivity(), View.OnClickListener {
    private lateinit var etA : EditText
    private lateinit var etB : EditText
    private lateinit var btnHitung1 : Button
    private lateinit var tvHasil1 : TextView
    private lateinit var btnHitung2 : Button
    private lateinit var tvHasil2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan3)

        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        btnHitung1 = findViewById(R.id.btnHitung1)
        tvHasil1 = findViewById(R.id.tvHasil1)
        btnHitung2 = findViewById(R.id.btnHitung2)
        tvHasil2 = findViewById(R.id.tvHasil2)

        btnHitung1.setOnClickListener(this)
        btnHitung2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btnHitung1 ->{
                if (etA.text.isEmpty()){
                    return
                }

                val a = etA.text.toString().toDouble()
                val fahrenheit = (a * 9/5) + 32
                tvHasil1.text = "Fahrenheit: $fahrenheit"
            }

            R.id.btnHitung2 ->{
                if (etB.text.isEmpty()){
                    return
                }

                val b = etB.text.toString().toDouble()
                val celcius = (b - 32) * 5/9
                tvHasil2.text = "Celcius: $celcius"
            }
        }
    }
}