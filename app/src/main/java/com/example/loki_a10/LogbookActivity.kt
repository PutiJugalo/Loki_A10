package com.example.loki_a10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Adapter.AdapterLogbook
import com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response.LogbookResponse
import com.example.loki_a10.databinding.ActivityLogbookBinding
import com.example.loki_a10.retrofitModel.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogbookActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLogbookBinding
    private lateinit var recycleView: RecyclerView
//  private lateinit var logbookList: ArrayList<Logbooks>
//    lateinit var adapter: AdapterLogbook

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_logbook)

        binding = ActivityLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
        supportActionBar?.hide()
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.setHomeButtonEnabled(true)

        //API
//        val adapter:AdapterLogbook=AdapterLogbook()

        recycleView = findViewById(R.id.recycler_view3)
        recycleView.layoutManager = LinearLayoutManager(this)
//        val gridLayoutManager = GridLayoutManager(TambahLogbookActivity(), 3)
//        recycleView.setLayoutManager(gridLayoutManager)
//        recycleView.setItemAnimator(DefaultItemAnimator())
//        recycleView.setNestedScrollingEnabled(true)
        getDataFromAPI()
    }

    private fun getDataFromAPI(){
        val sharedPreferences = applicationContext?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPreferences.getString("Token","")
        if (token !=null) {
            Log.d("TOKEN LH: ", token)
    }

        val list = ArrayList<LogbookResponse.Logbooks>()
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(applicationContext)

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.listLogbook("Bearer $token")

        callData.enqueue(object : Callback<LogbookResponse> {
            override fun onResponse(
                call: Call<LogbookResponse>,
                response: Response<LogbookResponse>
            ) {
                Toast.makeText(applicationContext, "List Logbook Ditampilkan", Toast.LENGTH_SHORT).show()
                val data = response.body()
                data?.logbooks.let {
                    if (it !=null) {
                        list.addAll(it)
                    }
                }
                val adapterGet = AdapterLogbook(list)
                recycleView.adapter = adapterGet
            }

            override fun onFailure(call: Call<LogbookResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Gagal", Toast.LENGTH_SHORT).show()
                Log.d("throwable", t.toString())
            }
        })
    }

//    private fun getDataFromAPI() {
//        //Get list Logbook
//        lateinit var binding: ContentLogbookBinding
//        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?:return
//        val token = sharedPref.getString("TOKEN", null)
//
//        Log.d("listLogbook", token.toString())
//
//        val listLogbook = ArrayList<Logbooks>()
//        recycleView.setHasFixedSize(true)
//        recycleView.layoutManager = LinearLayoutManager(this)
//
//        binding = ContentLogbookBinding.inflate(layoutInflater)
//
//        setContentView(binding.root)
//
//        val client: UserApi = Retrofit().getService()
//        val call : Call<Logbooks> = client.listLogbook("Bearer " + token)
//
//        call.enqueue(object : Callback<Logbooks> {
//            //            private lateinit var binding: ContentLogbookBinding
//            override fun onResponse(call: Call<Logbooks>, response: Response<Logbooks>) {
////                binding = ContentLogbookBinding.inflate(layoutInflater)
//                val respon = response.body()
//                Log.d("listLogbook-debug", "respon : "+ respon)
//
//                val adapterGet = AdapterLogbook(listLogbook)
//                recycleView.adapter = adapterGet
//            }
//
//            override fun onFailure(call: Call<Logbooks>, t: Throwable) {
//                Log.d("listLogbook-debug", t.localizedMessage)
//            }
//
//        })
//    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun ke_tambahLogbook(view: View) {
        intent = Intent(this, TambahLogbookActivity::class.java)
        startActivity(intent)
    }
}