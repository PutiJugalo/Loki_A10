package com.example.loki_a10

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.loki_a10.databinding.ActivityDetailKpBinding
import com.example.loki_a10.mynotification.NotificationChannelActivity

class DetailKpActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDetailKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kp)
        binding = ActivityDetailKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val bundle : Bundle? = intent.extras
        val namaInstansi = bundle!!.getString("namaInstansi")

        binding.textNamaInstansidiDetailKP.text = namaInstansi

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.setHomeButtonEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    fun ke_logbook(view: View) {
        intent = Intent(this, LogbookActivity::class.java)
        startActivity(intent)
    }
    fun ke_permohonanKp(view: View) {
        intent = Intent(this, PermohonanKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_laporanKp(view: View) {
        intent = Intent(this, LaporanKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_daftarSeminarKP(view: View) {
        intent = Intent(this, DaftarSeminarKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_laporKPSelesai(view: View) {
        intent = Intent(this, LaporKpSelesaiActivity::class.java)
        startActivity(intent)
    }
    fun ke_notifTest(view: View) {
        intent = Intent(this, NotificationChannelActivity::class.java)
        startActivity(intent)
    }
}