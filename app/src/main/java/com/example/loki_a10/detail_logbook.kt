package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.ui.AppBarConfiguration
import com.example.loki_a10.databinding.ActivityDetailLogbookBinding
import com.example.loki_a10.databinding.ActivityLogbookBinding

class detail_logbook : AppCompatActivity() {
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

        binding.textNamaKegiatanDetailLogbook.text = namaKegiatan
        binding.textTanggaldiDetailLogbook.text = tanggal
    }
    fun ke_editLogbook(view: View) {
        intent = Intent(this, edit_logbook::class.java)
        startActivity(intent)
    }
}