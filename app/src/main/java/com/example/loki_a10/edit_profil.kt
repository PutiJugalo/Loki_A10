package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class edit_profil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        supportActionBar?.hide()
    }

    fun ubahProfilClicked(view: View) {
        Toast.makeText(this, "Profil Berhasil Diubah", Toast.LENGTH_SHORT).show()
    }
}