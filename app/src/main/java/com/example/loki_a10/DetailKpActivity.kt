package com.example.loki_a10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.loki_a10.databinding.ActivityDetailKpBinding
import com.example.loki_a10.models.GetDataResponse
import com.example.loki_a10.models.GetDetailKPResponse
import com.example.loki_a10.mynotification.NotificationChannelActivity
import com.example.loki_a10.retrofitModel.Retrofit
import com.example.loki_a10.retrofitModel.UserApi
import retrofit2.Call
import java.util.NavigableMap

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

        binding.Agency.text = namaInstansi
        val sharedPref = getSharedPreferences("mahasiswapref", Context.MODE_PRIVATE)?: return
        val Judul = sharedPref.getString("tittle",null)
        val Nama = sharedPref.getString("grade",null)
        val Supervisor = sharedPref.getString("supervisor",null)
        val Agency = sharedPref.getString("Agency",null)

        binding.Judul.text = Judul
        binding.nama.text = Nama
        binding.Supervisor.text = Supervisor
        binding.Agency.text = Agency

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
        intent = Intent(this, dataPesertaSeminar::class.java)
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