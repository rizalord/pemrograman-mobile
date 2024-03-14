package com.example.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Latihan4 : AppCompatActivity(), View.OnClickListener {
    private lateinit var etA : EditText
    private lateinit var btnCek : Button
    private lateinit var tvHasil : TextView
    private lateinit var btnKosong : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan4)

        etA = findViewById(R.id.et_a)
        btnCek = findViewById(R.id.btnCek)
        tvHasil = findViewById(R.id.tvHasil)
        btnKosong = findViewById(R.id.btnKosong)

        btnCek.setOnClickListener(this)
        btnKosong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (etA.text.isEmpty()){
            return
        }

        val a = etA.text.toString().toDouble()

        when(v?.id){
            R.id.btnCek ->{
                if (a % 2 == 0.0){
                    tvHasil.text = "Genap"
                } else {
                    tvHasil.text = "Ganjil"
                }
            }

            R.id.btnKosong ->{
                etA.text.clear()
                tvHasil.text = "Hasil"
            }
        }
    }
}