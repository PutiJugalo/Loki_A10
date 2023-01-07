package com.example.loki_a10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.R
import com.example.loki_a10.models.InternshipsItem

class AdapterDataPeserta ():
    RecyclerView.Adapter<AdapterDataPeserta.dataPesertaViewHolder>() {

    private lateinit var dataPesertaKpListener: clickListener

    var listMahasiswaa: List<InternshipsItem> = ArrayList()

    fun setListMahasiswa(listMahasiswa: List<InternshipsItem>){
        this.listMahasiswaa = listMahasiswa
        notifyDataSetChanged()
    }



    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        dataPesertaKpListener = listener
    }

    inner class dataPesertaViewHolder(itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView) {
        val nama: TextView =itemView.findViewById(R.id.tvnama)
        val nim: TextView = itemView.findViewById(R.id.tvnim)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dataPesertaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_rv4, parent, false)
        return dataPesertaViewHolder(view, dataPesertaKpListener)
    }

    override fun onBindViewHolder(holder: dataPesertaViewHolder, position: Int) {
        val item : InternshipsItem = listMahasiswaa.get(position)
        holder.nama.text = item.name
        holder.nim.text = item.nim
    }

    override fun getItemCount(): Int {
        return listMahasiswaa.size
    }
}