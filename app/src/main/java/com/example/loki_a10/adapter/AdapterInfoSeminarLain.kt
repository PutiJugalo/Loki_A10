package com.example.loki_a10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response.InformasiSeminarResponse
import com.example.loki_a10.R

class AdapterInfoSeminarLain(private var listMhsLain:ArrayList<InformasiSeminarResponse>) : RecyclerView.Adapter<AdapterInfoSeminarLain.mhsLainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mhsLainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_rv2, parent, false)
        return mhsLainViewHolder(view)
    }

    override fun onBindViewHolder(holder: mhsLainViewHolder, position: Int) {
        val posisiInfoSeminarLain = listMhsLain[position]
        holder.namaMhsLain.text = posisiInfoSeminarLain.count.toString()
        holder.tanggalSeminarLain.text = posisiInfoSeminarLain.status
    }

    override fun getItemCount(): Int {
        return listMhsLain.size
    }
    class mhsLainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaMhsLain: TextView = itemView.findViewById(R.id.textNamaMhsLainDiInfoSeminar)
        val tanggalSeminarLain: TextView = itemView.findViewById(R.id.textTanggalSeminarMhsLainDiInfoSeminar)
    }
}