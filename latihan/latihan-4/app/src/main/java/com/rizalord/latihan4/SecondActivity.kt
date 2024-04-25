package com.rizalord.latihan4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var tvNim: TextView
    private lateinit var tvNama: TextView
    private lateinit var tvAlamat: TextView
    private lateinit var tvJk: TextView
    private lateinit var tvTglLahir: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the views
        tvNim = findViewById(R.id.tvNim)
        tvNama = findViewById(R.id.tvNama)
        tvAlamat = findViewById(R.id.tvAlamat)
        tvJk = findViewById(R.id.tvJk)
        tvTglLahir = findViewById(R.id.tvTglLahir)

        // Get the data from the intent
        val nim = intent.getStringExtra("nim") ?: ""
        val nama = intent.getStringExtra("nama") ?: ""
        val alamat = intent.getStringExtra("alamat") ?: ""
        val jk = intent.getStringExtra("jk") ?: ""
        val tglLahir = intent.getStringExtra("tglLahir") ?: ""

        // Set the data to the views
        tvNim.text = nim
        tvNama.text = nama
        tvAlamat.text = alamat
        tvJk.text = jk
        tvTglLahir.text = tglLahir

        // Initialize the back button
        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

    }
}