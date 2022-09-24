package com.example.loki_a10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Logbook2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logbook2)

        supportActionBar?.hide()
    }
}