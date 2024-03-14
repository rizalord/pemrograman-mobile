package com.example.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Latihan5 : AppCompatActivity(), View.OnClickListener {
    private lateinit var etA : EditText
    private lateinit var btnKonversi : Button
    private lateinit var tvHasil : TextView
    private lateinit var btnKosong : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan5)

        etA = findViewById(R.id.et_a)
        btnKonversi = findViewById(R.id.btnKonversi)
        tvHasil = findViewById(R.id.tvHasil)
        btnKosong = findViewById(R.id.btnKosong)

        btnKonversi.setOnClickListener(this)
        btnKosong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (etA.text.isEmpty()){
            return
        }

        val a = etA.text.toString().toDouble() // cm

        when(v?.id){
            R.id.btnKonversi ->{
                // konversi ke km, hm, dam, m, dm, cm, mm
                val km = a / 100000
                val hm = a / 10000
                val dam = a / 1000
                val m = a / 100
                val dm = a / 10
                val cm = a
                val mm = a * 10

                tvHasil.text = "Km: $km\nHm: $hm\nDam: $dam\nM: $m\nDm: $dm\nCm: $cm\nMm: $mm"
            }

            R.id.btnKosong ->{
                etA.text.clear()
                tvHasil.text = "Hasil"
            }
        }
    }
}