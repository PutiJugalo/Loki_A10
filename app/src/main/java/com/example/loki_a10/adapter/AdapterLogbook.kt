package com.example.loki_a10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.R
import com.example.loki_a10.models.Logbook

class AdapterLogbook (private val listLogbook:ArrayList<Logbook>) : RecyclerView.Adapter<AdapterLogbook.logbookViewHolder>(){
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    class logbookViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaKegiatan: TextView = itemView.findViewById(R.id.namaLogbook)
        val tanggal: TextView = itemView.findViewById(R.id.tanggalLogbook)

        init {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): logbookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_logbook, parent, false)
        return logbookViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: logbookViewHolder, position: Int) {
        val posisiLogbook = listLogbook[position]
        holder.namaKegiatan.text = posisiLogbook.namaKegiatan
        holder.tanggal.text = posisiLogbook.tanggal
    }

    override fun getItemCount(): Int {
        return listLogbook.size
    }
}