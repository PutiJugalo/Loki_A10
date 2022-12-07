package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DaftarSeminarKpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_seminar_kp)

        supportActionBar?.hide()
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    fun ke_dataSeminarKP(view: View) {
        intent = Intent(this, DataSeminarKpActivity::class.java)
        startActivity(intent)
    }
}