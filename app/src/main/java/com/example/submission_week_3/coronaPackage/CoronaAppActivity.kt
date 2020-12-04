package com.example.submission_week_3.coronaPackage

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.submission_week_3.R
import com.example.submission_week_3.coronaPackage.adapter.CovidAdapter
import com.example.submission_week_3.coronaPackage.model.Covid
import com.example.submission_week_3.coronaPackage.model.ResponseServer
import com.example.submission_week_3.coronaPackage.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_corona_app.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoronaAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona_app)

        if (isConnect()){
            ConfigNetwork.getRetrofit().getDataCovid().enqueue(object : Callback<ResponseServer> {
                override fun onResponse(call: Call<ResponseServer>, response: Response<ResponseServer>) {
                    Log.d("success",response.message())
                    progress.visibility = View.GONE
                    if(response.isSuccessful){
                        val data = response.body()?.list_data
                        showData(data)
                    }
                }

                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    Log.d("error",t.message)
                    progress.visibility = View.GONE
                }
            })
        } else{
            progress.visibility = View.GONE
            Toast.makeText(this,"Tidak ada jaringan internet", Toast.LENGTH_LONG).show()
        }
    }
    private fun showData(data: ArrayList<Covid>?) {
        listCovid.adapter = CovidAdapter(data)
    }

    fun isConnect():Boolean{
        val connect:ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }
    }



