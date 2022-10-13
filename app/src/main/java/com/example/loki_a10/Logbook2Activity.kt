package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Logbook2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logbook2)

        supportActionBar?.hide()
    }
    fun ke_tambahLogbook(view: View) {
        intent = Intent(this, tambah_logbook::class.java)
        startActivity(intent)
    }
}