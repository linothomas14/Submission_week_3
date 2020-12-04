package com.example.submission_week_3.coronaPackage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission_week_3.R
import com.example.submission_week_3.coronaPackage.model.Covid
import kotlinx.android.synthetic.main.activity_item_covid_activity.view.*
import java.util.ArrayList

class CovidAdapter(var data: ArrayList<Covid>?) : RecyclerView.Adapter<CovidAdapter.CovidHolder>() {
    class CovidHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val provinsi = itemView.itemProvinsi
        val kasus = itemView.kasus
        val  dirawat= itemView.dirawat
        val  sembuh= itemView.sembuh
        val  meninggal= itemView.meninggal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_covid_activity,parent,false)
        val holder = CovidHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CovidHolder, position: Int) {
        holder.provinsi.text = data?.get(position)?.key
        holder.kasus.text = "Jumlah kasus :" + data?.get(position)?.jumlah_kasus
        holder.dirawat.text = "Jumlah dirawat :" + data?.get(position)?.jumlah_dirawat
        holder.meninggal.text = "Jumlah meninggal : " + data?.get(position)?.jumlah_meninggal
        holder.sembuh.text = "Jumlah sembuh : " + data?.get(position)?.jumlah_sembuh

    }

    override fun getItemCount(): Int {
        return data?.size?: 0
    }

}
