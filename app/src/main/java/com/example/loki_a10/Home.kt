package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun ButtonProfil(view: View) {
        intent = Intent(this, profil::class.java)
        startActivity(intent)

    }

    fun ButtonDetailKP(view: View) {
        intent = Intent(this, detailkp::class.java)
        startActivity(intent)
    }
}