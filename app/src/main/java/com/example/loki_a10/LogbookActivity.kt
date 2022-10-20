package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.adapter.AdapterLogbook
import com.example.loki_a10.databinding.ActivityLogbookBinding
import com.example.loki_a10.models.Logbook

class LogbookActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLogbookBinding
    private lateinit var recycleView: RecyclerView
    private lateinit var logbookList: ArrayList<Logbook>
    private lateinit var adapter: AdapterLogbook

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logbook)

//        binding = ActivityLogbookBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setSupportActionBar(binding.toolbar6)
        supportActionBar?.hide()
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.setHomeButtonEnabled(true)

        recycleView = findViewById(R.id.recycler_view3)
        recycleView.layoutManager = LinearLayoutManager(this)

        logbookList = ArrayList()

        logbookList.add(Logbook("Berdiskusi mengenai project", "01/03/2022"))
        logbookList.add(Logbook("Membuat project", "02/03/2022"))
        logbookList.add(Logbook("Membuat project", "03/03/2022"))
        logbookList.add(Logbook("Berdiskusi mengenai project", "01/03/2022"))
        logbookList.add(Logbook("Membuat project", "02/03/2022"))
        logbookList.add(Logbook("Membuat project", "03/03/2022"))
        logbookList.add(Logbook("Berdiskusi mengenai project", "01/03/2022"))
        logbookList.add(Logbook("Membuat project", "02/03/2022"))
        logbookList.add(Logbook("Membuat project", "03/03/2022"))
        logbookList.add(Logbook("Berdiskusi mengenai project", "01/03/2022"))
        logbookList.add(Logbook("Membuat project", "02/03/2022"))
        logbookList.add(Logbook("Membuat project", "03/03/2022"))
        logbookList.add(Logbook("Berdiskusi mengenai project", "01/03/2022"))
        logbookList.add(Logbook("Membuat project", "02/03/2022"))
        logbookList.add(Logbook("Membuat project", "03/03/2022"))

        adapter = AdapterLogbook(logbookList)
        recycleView.adapter = adapter
        adapter.setOnItemClickListener(object : AdapterLogbook.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@LogbookActivity, detail_logbook::class.java)
                intent.putExtra("namaKegiatan", logbookList[position].namaKegiatan)
                intent.putExtra("tanggalKegiatan",logbookList[position].tanggal)
                startActivity(intent)
            }

        })
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    fun ke_tambahLogbook(view: View) {
        intent = Intent(this, tambah_logbook::class.java)
        startActivity(intent)
    }
}