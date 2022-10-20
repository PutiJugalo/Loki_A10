package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.ui.AppBarConfiguration
import com.example.loki_a10.databinding.ActivityAbsensiSeminarBinding
import com.example.loki_a10.databinding.ActivityDetailKpBinding
import android.widget.Toast

class absensi_seminar : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAbsensiSeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absensi_seminar)
        binding = ActivityAbsensiSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val bundle : Bundle? = intent.extras
        val namaMhsLain = bundle!!.getString("namaMhsLain")
        val tanggalSeminarLain = bundle!!.getString("tanggalSeminarLain")

        binding.textNamadiAbsensi.text = namaMhsLain
        binding.textTanggaldiAbsensi.text = tanggalSeminarLain
    }

    fun tombolHadirClicked(view: View) {
        Toast.makeText(this, "Anda Sudah Hadir", Toast.LENGTH_SHORT).show()
    }
}