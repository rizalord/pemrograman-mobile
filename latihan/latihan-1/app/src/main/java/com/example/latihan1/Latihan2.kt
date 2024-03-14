package com.example.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Latihan2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var etR : EditText
    private lateinit var btnHitung : Button
    private lateinit var tvHasil : TextView
    private lateinit var btnKosong : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan2)

        etR = findViewById(R.id.et_r)
        btnHitung = findViewById(R.id.btnHitung)
        tvHasil = findViewById(R.id.tvHasil)
        btnKosong = findViewById(R.id.btnKosong)

        btnHitung.setOnClickListener(this)
        btnKosong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (etR.text.isEmpty()){
            return
        }

        val r = etR.text.toString().toDouble()

        when(v?.id){
            R.id.btnHitung ->{
                // hitung keliling dan luas lingkaran
                val keliling = 2 * 3.14 * r
                val luas = 3.14 * r * r

                tvHasil.text = "Keliling: $keliling\nLuas: $luas"
            }

            R.id.btnKosong ->{
                etR.text.clear()
                tvHasil.text = "Hasil"
            }
        }
    }
}