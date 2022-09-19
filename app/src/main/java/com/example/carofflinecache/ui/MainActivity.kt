package com.example.carofflinecache.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.carofflinecache.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carBtn = findViewById<Button>(R.id.carButton)
        carBtn.setOnClickListener {
            val intent = Intent(
                this,
                CarActivity::class.java
            )
            startActivity(intent)
        }
    }
}