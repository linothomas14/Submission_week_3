package com.example.submission_week_3.museumPackage

import android.app.SearchManager
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.submission_week_3.R
import com.example.submission_week_3.museumPackage.adapter.MuseumAdapter
import com.example.submission_week_3.museumPackage.model.Museum
import com.example.submission_week_3.museumPackage.model.ResponseServer
import com.example.submission_week_3.museumPackage.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_museum_app.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MuseumAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_app)
        if (isConnect()) {
            showAllMuseum()
        } else {
            progress.visibility = View.GONE
            Toast.makeText(this, "Tidak ada jaringan internet", Toast.LENGTH_LONG).show()
        }
    }

    fun showData(data: ArrayList<Museum>?) {
        listMuseum.adapter = MuseumAdapter(data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        val menuItem = menu!!.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.action_search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isEmpty()) {
                        showAllMuseum()
                        listMuseum.adapter!!.notifyDataSetChanged()
                    } else {
                        val search = newText.toLowerCase(Locale.getDefault())
                        showFilterMuseum(search)
                        listMuseum.adapter!!.notifyDataSetChanged()
                    }
                    return false
                }
            })

            return super.onCreateOptionsMenu(menu)
        }
    }
    private fun showFilterMuseum(search: String) {
        //filter
        ConfigNetwork.getRetrofit().getFilterMuseum("$search")
            .enqueue(object : Callback<ResponseServer> {
                override fun onResponse(
                    call: Call<ResponseServer>,
                    response: Response<ResponseServer>
                ) {
                    progress.visibility = View.GONE
                    if (response.isSuccessful) {
                        val data: java.util.ArrayList<Museum>? = response.body()?.data
                        showData(data)
                    }
                }

                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    Log.d("error", t.message)
                    progress.visibility = View.GONE
                }
            })
    }

    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }

    fun showAllMuseum(){
        ConfigNetwork.getRetrofit().getDataMuseum().enqueue(object : Callback<ResponseServer> {
            override fun onResponse(
                call: Call<ResponseServer>, response: Response<ResponseServer>
            ) {
                Log.d("success", response.message())
                progress.visibility = View.GONE
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    showData(data)
                }
            }
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                Log.d("error", t.message)
                progress.visibility = View.GONE
            }
        })

    }

}
