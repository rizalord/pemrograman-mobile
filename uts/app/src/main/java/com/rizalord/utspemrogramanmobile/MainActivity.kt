package com.rizalord.utspemrogramanmobile

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var etNik : EditText
    private lateinit var etNama: EditText
    private lateinit var etTglLahir: EditText
    private lateinit var etAlamat : EditText
    private lateinit var etUsia : EditText
    private lateinit var spJk: Spinner
    private lateinit var rgStatus: RadioGroup
    private lateinit var cb1: CheckBox
    private lateinit var cb2: CheckBox
    private lateinit var cb3: CheckBox
    private lateinit var cb4: CheckBox
    private lateinit var cb5: CheckBox
    private lateinit var etEmail : EditText

    private lateinit var btnClear : Button
    private lateinit var btnSubmit : Button

    private var nik: String = ""
    private var nama: String = ""
    private var tglLahir: String = ""
    private var alamat: String = ""
    private var usia: String = ""
    private var jk: String = ""
    private var status: String = ""
    private var competencies: Set<String> = setOf()
    private var email: String = ""

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

    private var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the views
        etNik = findViewById(R.id.etNik)
        etNama = findViewById(R.id.etNama)
        etTglLahir = findViewById(R.id.etTglLahir)
        etAlamat = findViewById(R.id.etAlamat)
        etUsia = findViewById(R.id.etUsia)
        spJk = findViewById(R.id.spJk)
        rgStatus = findViewById(R.id.rgStatus)
        cb1 = findViewById(R.id.cb1)
        cb2 = findViewById(R.id.cb2)
        cb3 = findViewById(R.id.cb3)
        cb4 = findViewById(R.id.cb4)
        cb5 = findViewById(R.id.cb5)
        etEmail = findViewById(R.id.etEmail)
        btnClear = findViewById(R.id.btnClear)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Set the calendar
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)

        // Set the default value for the spinner
        spJk.setSelection(0)
        jk = spJk.selectedItem.toString()

        // Set listeners
        etTglLahir.setOnClickListener { showDatePicker() }
        rgStatus.setOnCheckedChangeListener { _, checkedId -> onStatusChangeListener(checkedId) }
        cb1.setOnCheckedChangeListener { _, isChecked -> onCompetenciesChangeListener(isChecked, cb1.text.toString()) }
        cb2.setOnCheckedChangeListener { _, isChecked -> onCompetenciesChangeListener(isChecked, cb2.text.toString()) }
        cb3.setOnCheckedChangeListener { _, isChecked -> onCompetenciesChangeListener(isChecked, cb3.text.toString()) }
        cb4.setOnCheckedChangeListener { _, isChecked -> onCompetenciesChangeListener(isChecked, cb4.text.toString()) }
        cb5.setOnCheckedChangeListener { _, isChecked -> onCompetenciesChangeListener(isChecked, cb5.text.toString()) }
        btnClear.setOnClickListener { onClearClickListener() }
        btnSubmit.setOnClickListener { onSubmitClickListener() }

    }

    fun validateForm(): Boolean {
        if (nik.isEmpty()) {
            etNik.error = "NIK tidak boleh kosong"
            return false
        }

        if (nik.length != 16) {
            etNik.error = "NIK harus 16 digit"
            return false
        }

        if (nama.isEmpty()) {
            etNama.error = "Nama tidak boleh kosong"
            return false
        }

        if (tglLahir.isEmpty()) {
            etTglLahir.error = "Tanggal Lahir tidak boleh kosong"
            return false
        }

        if (alamat.isEmpty()) {
            etAlamat.error = "Alamat tidak boleh kosong"
            return false
        }

        if (usia.isEmpty()) {
            etUsia.error = "Usia tidak boleh kosong"
            return false
        }

        if (jk.isEmpty()) {
            Toast.makeText(this, "Jenis Kelamin tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return false
        }

        if (status.isEmpty()) {
            Toast.makeText(this, "Status kewarganegaraan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isEmpty()) {
            etEmail.error = "Email tidak boleh kosong"
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Email tidak valid"
            return false
        }

        return true
    }

    fun onSubmitClickListener() {
        nik = etNik.text.toString()
        nama = etNama.text.toString()
        tglLahir = etTglLahir.text.toString()
        alamat = etAlamat.text.toString()
        usia = etUsia.text.toString()
        email = etEmail.text.toString()

        if (!validateForm()) {
            return
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("nik", nik)
        intent.putExtra("nama", nama)
        intent.putExtra("tglLahir", tglLahir)
        intent.putExtra("alamat", alamat)
        intent.putExtra("usia", usia)
        intent.putExtra("jk", jk)
        intent.putExtra("status", status)
        intent.putExtra("kompetensi", competencies.joinToString(", "))
        intent.putExtra("email", email)

        startActivity(intent)
    }

    fun onClearClickListener() {
        etNik.text.clear()
        etNama.text.clear()
        etTglLahir.text.clear()
        etAlamat.text.clear()
        etUsia.text.clear()
        spJk.setSelection(0)
        rgStatus.clearCheck()
        cb1.isChecked = false
        cb2.isChecked = false
        cb3.isChecked = false
        cb4.isChecked = false
        cb5.isChecked = false
        etEmail.text.clear()

        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)

        nik = ""
        nama = ""
        tglLahir = ""
        alamat = ""
        usia = ""
        jk = spJk.selectedItem.toString()
        status = ""
        competencies = setOf()
        email = ""

        rgStatus.setOnCheckedChangeListener(null)
        rgStatus.clearCheck()
        rgStatus.setOnCheckedChangeListener { _, checkedId -> onStatusChangeListener(checkedId) }
    }

    fun onCompetenciesChangeListener(isChecked: Boolean, competency: String) {
        if (isChecked) {
            competencies += competency
        } else {
            competencies -= competency
        }
    }

    fun onStatusChangeListener(checkedId: Int) {
        status = when (checkedId) {
            R.id.rbWni -> "WNI"
            R.id.rbWna -> "WNA"
            else -> "WNI"
        }
    }

    fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                etTglLahir.setText("$dayOfMonth/$monthOfYear/$year")

                this.year = year
                this.month = monthOfYear
                this.day = dayOfMonth

                usia = (calendar.get(Calendar.YEAR) - year).toString()
                etUsia.setText("$usia Tahun")
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}