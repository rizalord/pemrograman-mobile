package com.example.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Contoh : AppCompatActivity(), View.OnClickListener {
    //inisialisasi class obyek
    lateinit var btntambah : Button
    lateinit var btnkurang : Button
    lateinit var btnkali : Button
    lateinit var btnbagi : Button
    lateinit var btnkosong : Button
    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var tvHasil : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contoh)

        // inisialisasi class obyek
        btntambah = findViewById(R.id.btntambah)
        btnkurang = findViewById(R.id.btnkurang)
        btnkali = findViewById(R.id.btnkali)
        btnbagi = findViewById(R.id.btnbagi)
        btnkosong = findViewById(R.id.btnkosong)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        tvHasil = findViewById(R.id.tvHasil)

        // aksi ketika button di klik
        btntambah.setOnClickListener(this)
        btnkurang.setOnClickListener(this)
        btnkali.setOnClickListener(this)
        btnbagi.setOnClickListener(this)
        btnkosong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        /*Variabel untuk simpan input A dan B,
 konversi ke Double agar dapat dikalkulasi*/
        var a = etA.text.toString().toDouble()
        var b = etB.text.toString().toDouble()
        //Beri nilai awal variabel hasil untuk simpan nilai operasi
        var hasil=0.0
        //cek button mana yang dioperasikan
        when(v?.id){
            R.id.btntambah ->{
                hasil = a+b
            }
            R.id.btnkurang ->{
                hasil = a-b
            }
            R.id.btnkali ->{
                hasil = a*b
            }
            R.id.btnbagi ->{
                hasil = a/b
            }
            R.id.btnkosong ->{
                etA.text.clear() //mengosongkan edittext
                etB.text.clear()
                hasil=0.0
                etA.requestFocus() //set lokasi kursor
            }
        }
        tvHasil.text = "Hasil = $hasil"

    }


}