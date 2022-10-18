package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class absensi_seminar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absensi_seminar)

        supportActionBar?.hide()
    }

    fun tombolHadirClicked(view: View) {
        Toast.makeText(this, "Anda Sudah Hadir", Toast.LENGTH_SHORT).show()
    }
}