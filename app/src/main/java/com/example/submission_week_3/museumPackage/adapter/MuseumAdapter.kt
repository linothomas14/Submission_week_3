package com.example.submission_week_3.museumPackage.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission_week_3.R
import com.example.submission_week_3.museumPackage.DetailMuseumActivity
import com.example.submission_week_3.museumPackage.model.Museum
import kotlinx.android.synthetic.main.item_museum.view.*

class MuseumAdapter(val data: ArrayList<Museum>?) : RecyclerView.Adapter<MuseumAdapter.WisataHolder>() {
    class WisataHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nama = itemView.nama
        val alamat = itemView.alamat
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_museum,parent,false)
        val holder = WisataHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: WisataHolder, position: Int) {
        holder.alamat.text = data?.get(position)?.alamat_jalan
        holder.nama.text = data?.get(position)?.nama

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailMuseumActivity::class.java)
            intent.putExtra("nama",data?.get(position)?.nama)
            intent.putExtra("alamat",data?.get(position)?.alamat_jalan)
            intent.putExtra("kec",data?.get(position)?.kecamatan)
            intent.putExtra("kota",data?.get(position)?.kabupaten_kota)
            intent.putExtra("provinsi",data?.get(position)?.propinsi)
            intent.putExtra("kelola",data?.get(position)?.pengelola)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  data?.size?: 0
    }
}