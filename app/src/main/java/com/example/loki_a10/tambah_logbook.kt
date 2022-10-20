package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class tambah_logbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_logbook)

        supportActionBar?.hide()
    }

    fun tambahLogbookClicked(view: View) {
        Toast.makeText(this, "Logbook Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
    }

}