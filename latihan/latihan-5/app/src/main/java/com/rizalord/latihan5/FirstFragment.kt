package com.rizalord.latihan5

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import java.util.Calendar

class FirstFragment : Fragment() {

    private lateinit var edNim : EditText
    private lateinit var edNama: EditText
    private lateinit var edAlamat : EditText
    private lateinit var rgJk : RadioGroup
    private lateinit var edTglLahir : EditText
    private lateinit var btnClear : Button
    private lateinit var btnSubmit : Button

    private var nim: String = ""
    private var nama: String = ""
    private var alamat: String = ""
    private var jk: String = ""
    private var tglLahir: String = ""

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

    private var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Initialize the views
        edNim = view.findViewById(R.id.edNim)
        edNama = view.findViewById(R.id.edNama)
        edAlamat = view.findViewById(R.id.edAlamat)
        rgJk = view.findViewById(R.id.rgJk)
        edTglLahir = view.findViewById(R.id.edTglLahir)
        btnClear = view.findViewById(R.id.btnClear)
        btnSubmit = view.findViewById(R.id.btnSubmit)

        // Set the calendar
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)

        edTglLahir.setText("$day/$month/$year")
        edTglLahir.setOnClickListener { showDatePicker()  }

        // Clear the form
        btnClear.setOnClickListener {
            edNim.text.clear()
            edNama.text.clear()
            edAlamat.text.clear()
            rgJk.setOnCheckedChangeListener(null)
            rgJk.clearCheck()
            rgJk.setOnCheckedChangeListener { _, checkedId ->
                val radioButton = view.findViewById<RadioButton>(checkedId)
                jk = radioButton.text.toString()
            }
            edTglLahir.text.clear()

            year = calendar.get(Calendar.YEAR)
            month = calendar.get(Calendar.MONTH)
            day = calendar.get(Calendar.DAY_OF_MONTH)
        }

        // Radio Group
        rgJk.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = view.findViewById<RadioButton>(checkedId)
            jk = radioButton.text.toString()
        }

        // Submit the form
        btnSubmit.setOnClickListener { submitForm() }

        return view
    }

    private fun showDatePicker () {

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                edTglLahir.setText("$dayOfMonth/$monthOfYear/$year")

                this.year = year
                this.month = monthOfYear
                this.day = dayOfMonth
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun submitForm () {
        nim = edNim.text.toString()
        nama = edNama.text.toString()
        alamat = edAlamat.text.toString()
        tglLahir = edTglLahir.text.toString()

        // Validate the form
        val errMessage = when {
            nim.isEmpty() -> "NIM tidak boleh kosong"
            nama.isEmpty() -> "Nama tidak boleh kosong"
            alamat.isEmpty() -> "Alamat tidak boleh kosong"
            jk.isEmpty() -> "Jenis Kelamin tidak boleh kosong"
            tglLahir.isEmpty() -> "Tanggal Lahir tidak boleh kosong"
            else -> ""
        }

        if (errMessage.isNotEmpty()) {
            Toast.makeText(requireContext(), errMessage, Toast.LENGTH_SHORT).show()
            return
        }

        // Intent to the next activity
        val intent = Intent(requireContext(), SecondActivity::class.java)
        intent.putExtra("nim", nim)
        intent.putExtra("nama", nama)
        intent.putExtra("alamat", alamat)
        intent.putExtra("jk", jk)
        intent.putExtra("tglLahir", tglLahir)

        startActivity(intent)
    }
}