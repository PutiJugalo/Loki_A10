package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class detailkp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailkp)
    }

    fun ButtonBack(view: View) {
        intent = Intent(this, Home ::class.java)
        startActivity(intent)
    }
}