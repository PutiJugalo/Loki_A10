package com.example.loki_a10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.adapter.AdapterDataPeserta
import com.example.loki_a10.databinding.ActivityDataPesertaSeminarBinding
import com.example.loki_a10.models.GetDataResponse
import com.example.loki_a10.models.InternshipsItem
import com.example.loki_a10.retrofitModel.Retrofit
import com.example.loki_a10.retrofitModel.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class dataPesertaSeminar : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AdapterDataPeserta
    lateinit var binding: ActivityDataPesertaSeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataPesertaSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter:AdapterDataPeserta = AdapterDataPeserta()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)


        val data =ArrayList<InternshipsItem>()


        recyclerView =binding.rvDataPeserta


        val client: UserApi = Retrofit().getService()
        val call: Call<GetDataResponse> = client.getData("Bearer "+token)

        call.enqueue(object : Callback<GetDataResponse> {
            override fun onResponse( call: Call<GetDataResponse>, response: Response<GetDataResponse>) {

                val respon: GetDataResponse? = response.body()
                if (respon!= null){
                    val list : List<InternshipsItem> = respon.internships as List<InternshipsItem>
                    adapter.setListMahasiswa(list)
                }


                Log.d("anjay", response.toString())
            }

            override fun onFailure(call: Call<GetDataResponse>, t: Throwable) {
                Toast.makeText(this@dataPesertaSeminar, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : AdapterDataPeserta.clickListener{
            override fun onItemClick(position: Int) {
                val DataSeminarKpActivity = Intent (this@dataPesertaSeminar, DaftarSeminarKpActivity::class.java)
                DataSeminarKpActivity.putExtra("namaMahasiswa",data[position].name)
                DataSeminarKpActivity.putExtra("nimMahasiswa",data[position].nim)
                startActivity(DataSeminarKpActivity)
            }
        })

    }
}