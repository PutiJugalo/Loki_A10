package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TambahPengajuanKpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pengajuan_kp)

        supportActionBar?.hide()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    fun ke_main(view: View) {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun ke_anggotaKelompok(view: View) {
        intent = Intent(this, anggota_kelompok::class.java)
        startActivity(intent)
    }
}