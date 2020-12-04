package com.example.submission_week_3.museumPackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission_week_3.R
import kotlinx.android.synthetic.main.activity_detail_museum.*

class DetailMuseumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_museum)
        val nama:String? = intent.getStringExtra("nama")
        val alamat:String? = intent.getStringExtra("alamat")
        val kec:String? = intent.getStringExtra("kec")
        val kota:String? = intent.getStringExtra("kota")
        val provinsi:String? = intent.getStringExtra("provinsi")
        val kelola:String? = intent.getStringExtra("kelola")

        tv_judul.text = nama
        tv_alamat.text = "Alamat :" + alamat
        tv_kec.text = "Kec." + kec
        tv_kota.text =  kota
        tv_provinsi.text = provinsi
        tv_pengelola.text = "Dikelola oleh : "+ kelola
    }
}
