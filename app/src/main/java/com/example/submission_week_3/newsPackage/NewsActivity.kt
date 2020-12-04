package com.example.submission_week_3.newsPackage

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.submission_week_3.R
import com.example.submission_week_3.newsPackage.adapter.NewsAdapter
import com.example.submission_week_3.newsPackage.model.News
import com.example.submission_week_3.newsPackage.model.ResponseServer
import com.example.submission_week_3.newsPackage.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        if (isConnect()) {
            ConfigNetwork.getRetrofit().getDataNews().enqueue(object : Callback<ResponseServer> {
                override fun onResponse(call: Call<ResponseServer>, response: Response<ResponseServer>) {
                    if(response.isSuccessful){
                        val status:String? = response.body()?.status
                        if(status=="ok"){
                            val data = response.body()?.articles
                            showData(data)
                            progress.visibility = View.GONE
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    Log.d("error server", t.message)
                    progress.visibility = View.GONE
                }
            })
        }
    }

    private fun showData(data: ArrayList<News>?) {
       listNews.adapter = NewsAdapter(data)
    }

    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }
}
