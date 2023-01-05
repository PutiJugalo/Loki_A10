package com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response.LogbookResponse
import com.example.loki_a10.R

class AdapterLogbook(private var listLogbook: ArrayList<LogbookResponse.Logbooks>) : RecyclerView.Adapter<AdapterLogbook.logbookViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): logbookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_logbook, parent, false)
        return logbookViewHolder(view)
    }

    override fun onBindViewHolder(holder: logbookViewHolder, position: Int) {
        val currentPostion = listLogbook[position]
        holder.id.text = currentPostion.id.toString()
        holder.internship.text = currentPostion.internship_id.toString()
        holder.date.text = currentPostion.date
        holder.activities.text = currentPostion.activities
        holder.note.text = currentPostion.note
        holder.status.text = currentPostion.status.toString()
        holder.created.text = currentPostion.created_at
        holder.updated.text = currentPostion.updated_at
    }
    override fun getItemCount(): Int {
        return listLogbook.size
    }

    class logbookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.idLogbook)
        val internship: TextView = itemView.findViewById(R.id.internshipLogbook)
        val date: TextView = itemView.findViewById(R.id.dateLogbook)
        val activities: TextView = itemView.findViewById(R.id.activitiesLogbook)
        val note: TextView = itemView.findViewById(R.id.noteLogbook)
        val status: TextView = itemView.findViewById(R.id.noteLogbook)
        val created: TextView = itemView.findViewById(R.id.mulaiLogbook)
        val updated: TextView = itemView.findViewById(R.id.updateLogbook)

    }
}