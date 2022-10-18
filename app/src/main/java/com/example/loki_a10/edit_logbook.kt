package com.example.loki_a10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class edit_logbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_logbook)

        supportActionBar?.hide()
    }

    fun editLogbookClicked(view: View) {
        Toast.makeText(this, "Logbook Berhasil Diubah", Toast.LENGTH_SHORT).show()
    }
}