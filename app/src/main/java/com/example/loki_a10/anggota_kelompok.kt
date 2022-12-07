package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class anggota_kelompok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anggota_kelompok)

        supportActionBar?.hide()
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    fun ke_main(view: View) {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}