package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.adapter.MyAdapter
import com.example.loki_a10.databinding.ActivityLogbookBinding

class LogbookActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLogbookBinding
    private lateinit var recycleView: RecyclerView
    private lateinit var instList: ArrayList<NamaInstansi>
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_logbook)

        binding = ActivityLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar6)
        supportActionBar?.hide()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recycleView = findViewById(R.id.recycler_view3)
        recycleView.layoutManager = LinearLayoutManager(this)

        instList = ArrayList()

        instList.add(NamaInstansi(R.drawable.ic_book, "Berdiskusi mengenai project", "01/03/2022"))
        instList.add(NamaInstansi(R.drawable.ic_book, "Membuat project", "02/03/2022"))
        instList.add(NamaInstansi(R.drawable.ic_book, "Membuat project", "03/03/2022"))

        adapter = MyAdapter(instList)
        recycleView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, LogbookActivity::class.java)
            startActivity(intent )
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun init(){
        recycleView = findViewById(R.id.recycler_view3)

        var instList = ArrayList<NamaInstansi>()
        instList.add(NamaInstansi(R.drawable.ic_book, "Berdiskusi mengenai project", "01/03/2022"))
        instList.add(NamaInstansi(R.drawable.ic_book, "Membuat project", "02/03/2022"))
        instList.add(NamaInstansi(R.drawable.ic_book, "Membuat project", "03/03/2022"))

        adapter = MyAdapter(instList)

    }
}