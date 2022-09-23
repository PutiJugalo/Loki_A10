package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class profil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
    }

    fun ButtonEditProfil(view: View) {
        intent = Intent(this, EditProfil::class.java)
        startActivity(intent)
    }

    fun ButtonBack(view: View) {
        intent = Intent(this, Home ::class.java)
        startActivity(intent)
    }

    fun ButtonLogout(view: View) {
        intent = Intent(this, MainActivity ::class.java)
        startActivity(intent)
    }

    fun ButtonUbahPass(view: View) {
        intent = Intent(this, UbahSandi ::class.java)
        startActivity(intent)
    }
}