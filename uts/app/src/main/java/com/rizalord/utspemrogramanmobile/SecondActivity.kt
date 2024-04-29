package com.rizalord.utspemrogramanmobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var tvNik: TextView
    private lateinit var tvNama: TextView
    private lateinit var tvTglLahir: TextView
    private lateinit var tvAlamat: TextView
    private lateinit var tvUsia: TextView
    private lateinit var tvJk: TextView
    private lateinit var tvStatus: TextView
    private lateinit var tvKompetensi: TextView
    private lateinit var tvEmail: TextView
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
        tvNik = findViewById(R.id.tvNik)
        tvNama = findViewById(R.id.tvNama)
        tvTglLahir = findViewById(R.id.tvTglLahir)
        tvAlamat = findViewById(R.id.tvAlamat)
        tvUsia = findViewById(R.id.tvUsia)
        tvJk = findViewById(R.id.tvJk)
        tvStatus = findViewById(R.id.tvStatus)
        tvKompetensi = findViewById(R.id.tvKompetensi)
        tvEmail = findViewById(R.id.tvEmail)

        // Get the data from the intent
        val nik = intent.getStringExtra("nik") ?: ""
        val nama = intent.getStringExtra("nama") ?: ""
        val tglLahir = intent.getStringExtra("tglLahir") ?: ""
        val alamat = intent.getStringExtra("alamat") ?: ""
        val usia = intent.getStringExtra("usia") ?: ""
        val jk = intent.getStringExtra("jk") ?: ""
        val status = intent.getStringExtra("status") ?: ""
        val kompetensi = intent.getStringExtra("kompetensi") ?: ""
        val email = intent.getStringExtra("email") ?: ""

        // Set the data to the views
        tvNik.text = nik
        tvNama.text = nama
        tvTglLahir.text = tglLahir
        tvAlamat.text = alamat
        tvUsia.text = usia
        tvJk.text = jk
        tvStatus.text = status
        tvKompetensi.text = kompetensi
        tvEmail.text = email

        // Initialize the back button
        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener { finish() }
    }
}