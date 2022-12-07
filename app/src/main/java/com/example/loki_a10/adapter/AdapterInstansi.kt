package com.example.loki_a10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.R
import com.example.loki_a10.models.Instansi
import com.example.loki_a10.models.Logbook

class AdapterInstansi (private val listInstansi:ArrayList<Instansi>) : RecyclerView.Adapter<AdapterInstansi.instansiViewHolder>(){
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    class instansiViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaInstansi: TextView = itemView.findViewById(R.id.textInstansiHome)
        val statusKP: TextView = itemView.findViewById(R.id.textStatusKP)

        init {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): instansiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_rv1, parent, false)
        return instansiViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: instansiViewHolder, position: Int) {
        val posisiInstansi = listInstansi[position]
        holder.namaInstansi.text = posisiInstansi.namaInstansi
        holder.statusKP.text = posisiInstansi.statusKP
    }

    override fun getItemCount(): Int {
        return listInstansi.size
    }
}