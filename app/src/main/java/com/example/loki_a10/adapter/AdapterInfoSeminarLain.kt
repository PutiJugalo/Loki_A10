package com.example.loki_a10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.R
import com.example.loki_a10.models.InfoSeminarLain
import com.example.loki_a10.models.Instansi

class AdapterInfoSeminarLain(private val listMhsLain:ArrayList<InfoSeminarLain>) : RecyclerView.Adapter<AdapterInfoSeminarLain.mhsLainViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    class mhsLainViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaMhsLain: TextView = itemView.findViewById(R.id.textNamaMhsLainDiInfoSeminar)
        val tanggalSeminarLain: TextView = itemView.findViewById(R.id.textTanggalSeminarMhsLainDiInfoSeminar)

        init {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mhsLainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_rv2, parent, false)
        return AdapterInfoSeminarLain.mhsLainViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: mhsLainViewHolder, position: Int) {
        val posisiInfoSeminarLain = listMhsLain[position]
        holder.namaMhsLain.text = posisiInfoSeminarLain.namaMhsLain
        holder.tanggalSeminarLain.text = posisiInfoSeminarLain.tanggalSeminarLain
    }

    override fun getItemCount(): Int {
        return listMhsLain.size
    }
}