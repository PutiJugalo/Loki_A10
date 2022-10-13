package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class detail_logbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_logbook)

        supportActionBar?.hide()
    }
    fun ke_editLogbook(view: View) {
        intent = Intent(this, edit_logbook::class.java)
        startActivity(intent)
    }
}