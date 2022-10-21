package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class InputSeminarKPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data_seminar_kp)

        supportActionBar?.hide()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
    }

    fun ke_dataPesertaSeminarKP(view: View) {
        intent = Intent(this, DataSeminarKpActivity::class.java)
        startActivity(intent)
    }
}