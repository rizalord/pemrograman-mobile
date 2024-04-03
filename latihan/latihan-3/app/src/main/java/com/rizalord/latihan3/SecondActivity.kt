package com.rizalord.latihan3

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@SuppressLint("UseSwitchCompatOrMaterialCode")
class SecondActivity : AppCompatActivity() {
    private lateinit var parentLayout: ScrollView
    private lateinit var cb1: CheckBox
    private lateinit var cb2: CheckBox
    private lateinit var cb3: CheckBox
    private lateinit var sw: Switch
    private lateinit var pb: ProgressBar
    private lateinit var btnPb: Button
    private lateinit var rb: RatingBar
    private lateinit var sp: Spinner
    private lateinit var sb: SeekBar

    private val jurusan = arrayOf("-- Pilih Jurusan --", "Teknik Informatika", "Sistem Informasi", "Teknik Komputer", "Manajemen Informatika")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        parentLayout = findViewById(R.id.parentLayout)
        cb1 = findViewById(R.id.cb1)
        cb2 = findViewById(R.id.cb2)
        cb3 = findViewById(R.id.cb3)
        sw = findViewById(R.id.sw)
        pb = findViewById(R.id.pb)
        btnPb = findViewById(R.id.btnPb)
        rb = findViewById(R.id.rb)
        sp = findViewById(R.id.sp)
        sb = findViewById(R.id.seekBar)

        cb1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Anda memilih matkul Sistem Integrasi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Anda membatalkan pilihan matkul Sistem Integrasi", Toast.LENGTH_SHORT).show()
            }
        }

        cb2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Anda memilih matkul Pemrograman Mobile", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Anda membatalkan pilihan matkul Pemrograman Mobile", Toast.LENGTH_SHORT).show()
            }
        }

        cb3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Anda memilih matkul Pemrograman Web", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Anda membatalkan pilihan matkul Pemrograman Web", Toast.LENGTH_SHORT).show()
            }
        }

        sw.setOnCheckedChangeListener { buttonView, isChecked ->
            // change parent layout background color to dark gray if switch is checked
            if (isChecked) {
                parentLayout.setBackgroundColor(Color.DKGRAY)
            } else {
                parentLayout.setBackgroundColor(Color.WHITE)
            }
        }

        btnPb.setOnClickListener {
            // run progress bar from 0 to 100
            pb.progress = 0
            Thread {
                while (pb.progress < 100) {
                    pb.progress += 1
                    Thread.sleep(100)
                }

                runOnUiThread {
                    Toast.makeText(this, "Progress bar selesai", Toast.LENGTH_SHORT).show()
                }
            }.start()
        }

        rb.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this, "Anda memberikan rating sebesar $rating", Toast.LENGTH_SHORT).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jurusan)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = adapter

        sp.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) return
                Toast.makeText(this@SecondActivity, "Anda memilih jurusan ${jurusan[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // TODO("Not yet implemented")
            }
        })

        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var progress = 0

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                this.progress = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@SecondActivity, "Anda memilih nilai sebesar $progress", Toast.LENGTH_SHORT).show()
            }
        })
    }
}