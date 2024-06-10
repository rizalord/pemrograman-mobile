package com.rizalord.latihan6

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gridView = findViewById(R.id.gridView)

        val cats = ArrayList<Cat>()
        cats.add(Cat("Cat 1", R.drawable.cat_01))
        cats.add(Cat("Cat 2", R.drawable.cat_02))
        cats.add(Cat("Cat 3", R.drawable.cat_03))

        val gridAdapter = GridAdapter(this, cats)
        gridView.adapter = gridAdapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val cat = cats[position]
            Toast.makeText(this, "You clicked on ${cat.name}", Toast.LENGTH_SHORT).show()
        }
    }
}