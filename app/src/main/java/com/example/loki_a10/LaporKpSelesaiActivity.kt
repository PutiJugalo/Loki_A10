package com.example.loki_a10

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LaporKpSelesaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lapor_kp_selesai)

        supportActionBar?.hide()
    }
    fun ke_detailKP(view: View) {
        intent = Intent(this, DetailKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_home(view: View) {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}