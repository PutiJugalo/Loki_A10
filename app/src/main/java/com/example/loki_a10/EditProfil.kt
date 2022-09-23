package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EditProfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)
    }

    fun ButtonBack(view: View) {
        intent = Intent(this, profil ::class.java)
        startActivity(intent)
    }

    fun ButtonSave(view: View) {
        intent = Intent(this, profil ::class.java)
        startActivity(intent)
    }
}