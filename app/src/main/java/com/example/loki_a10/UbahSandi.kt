package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UbahSandi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_sandi)
    }

    fun ButtonBack(view: View) {
        intent = Intent(this, profil ::class.java)
        startActivity(intent)
    }

    fun ButtonUbah(view: View) {
        intent = Intent(this, profil ::class.java)
        startActivity(intent)
    }
}