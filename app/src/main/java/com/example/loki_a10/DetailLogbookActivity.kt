package com.example.loki_a10

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.loki_a10.databinding.ActivityDetailLogbookBinding

class DetailLogbookActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDetailLogbookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_logbook)

        binding = ActivityDetailLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val bundle : Bundle? = intent.extras
        val namaKegiatan = bundle!!.getString("namaKegiatan")
        val tanggal = bundle!!.getString("tanggalKegiatan")

        binding.activitiesdiDetailLogbook.text = namaKegiatan
        binding.notediDetailLogbook.text = tanggal
    }
    fun ke_editLogbook(view: View) {
        intent = Intent(this, edit_logbook::class.java)
        startActivity(intent)
    }
}