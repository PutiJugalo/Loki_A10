package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DetailKpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kp)
        supportActionBar?.hide()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    fun ke_dataSeminarKp(view: View) {
        intent = Intent(this, DataSeminarKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_logbook(view: View) {
        intent = Intent(this, LogbookActivity::class.java)
        startActivity(intent)
    }
    fun ke_permohonanKp(view: View) {
        intent = Intent(this, PermohonanKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_laporanKp(view: View) {
        intent = Intent(this, LaporanKpActivity::class.java)
        startActivity(intent)
    }
}