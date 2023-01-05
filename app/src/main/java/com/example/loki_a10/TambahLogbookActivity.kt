package com.example.loki_a10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response.TambahLogbookResponse
import com.example.loki_a10.databinding.ActivityTambahLogbookBinding
import com.example.loki_a10.retrofitModel.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahLogbookActivity : AppCompatActivity() {
    lateinit var binding : ActivityTambahLogbookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_tambah_logbook)
        binding = ActivityTambahLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }

    fun tambahLogbookClicked(view: View) {
        val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("Token: ", token)
        }
        val retrofitClient = RetrofitClient.create()
        val call = retrofitClient.tambahLogbook("Bearer $token")

        call.enqueue(object: Callback<TambahLogbookResponse> {
            override fun onFailure(call: Call<TambahLogbookResponse>, t: Throwable) {
                Log.d("tambahLogbook-debug",t.localizedMessage)
            }
            override fun onResponse(call: Call<TambahLogbookResponse>, response: Response<TambahLogbookResponse>) {
                Log.d("tambahLogbook-debug", "response : $response")

                val respon: TambahLogbookResponse? = response.body()
                if (respon != null && respon.status == "success" ) {

                    Log.d("tambahLogbook-debug", "$token|$respon")

                    Toast.makeText(this@TambahLogbookActivity, "Berhasil menambahkan data logbook", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, LogbookActivity::class.java)
                    startActivity(intent)
                    finish()

                }
            }
        })
        intent = Intent(this, LogbookActivity::class.java)
        Toast.makeText(this, "Berhasil melaporkan KP telah selesai", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

}