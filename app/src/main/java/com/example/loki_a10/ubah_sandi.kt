package com.example.loki_a10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ubah_sandi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_sandi)

        supportActionBar?.hide()
    }

    fun ubahPasswordClicked(view: View) {
        Toast.makeText(this, "Password Berhasil Diubah", Toast.LENGTH_SHORT).show()
    }
}