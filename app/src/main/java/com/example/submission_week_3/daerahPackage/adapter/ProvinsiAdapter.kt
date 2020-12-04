package com.example.submission_week_3.daerahPackage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission_week_3.R
import com.example.submission_week_3.daerahPackage.model.Daerah
import kotlinx.android.synthetic.main.item_provinsi.view.*

class ProvinsiAdapter(var data: ArrayList<Daerah>?) : RecyclerView.Adapter<ProvinsiAdapter.ProvinsiHolder>() {
    class ProvinsiHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id = itemView.itemId
        val provinsi = itemView.itemProvinsi
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_provinsi,parent,false)
        val holder = ProvinsiHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProvinsiHolder, position: Int) {
        holder.provinsi.text = data?.get(position)?.nama
        holder.id.text = data?.get(position)?.id
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}