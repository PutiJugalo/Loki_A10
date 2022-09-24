package com.example.loki_a10

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recycle_view1, parent, false)) {

    private var imgView: ImageView?= null
    private var txtTitle: TextView?= null
    private var txtSubTitle: TextView?= null

    init{
        imgView= itemView.findViewById(R.id.img_view)
        txtTitle= itemView.findViewById(R.id.txt_title)
        txtSubTitle= itemView.findViewById(R.id.txt_sub_title)
    }
    fun bind(data: NamaInstansi){
        imgView?.setImageResource(data.imgView)
        txtTitle?.text= data.txtTitle
        txtSubTitle?.text= data.txtSubTitle
    }
}