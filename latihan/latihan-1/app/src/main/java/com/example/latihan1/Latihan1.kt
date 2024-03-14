package com.example.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Latihan1 : AppCompatActivity(), View.OnClickListener {
    private lateinit var etA : EditText
    private lateinit var etB : EditText
    private lateinit var btnHitung : Button
    private lateinit var tvHasil : TextView
    private lateinit var btnKosong : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan1)

        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        btnHitung = findViewById(R.id.btnHitung)
        tvHasil = findViewById(R.id.tvHasil)
        btnKosong = findViewById(R.id.btnKosong)

        btnHitung.setOnClickListener(this)
        btnKosong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (etA.text.isEmpty() || etB.text.isEmpty()){
            return
        }

        val a = etA.text.toString().toDouble()
        val b = etB.text.toString().toDouble()

        when(v?.id){
            R.id.btnHitung ->{
                // hitung keliling dan luas persegi panjang
                val keliling = 2 * (a + b)
                val luas = a * b

                tvHasil.text = "Keliling: $keliling\nLuas: $luas"
            }

            R.id.btnKosong ->{
                etA.text.clear()
                etB.text.clear()
                tvHasil.text = "Hasil"
            }
        }
    }
}