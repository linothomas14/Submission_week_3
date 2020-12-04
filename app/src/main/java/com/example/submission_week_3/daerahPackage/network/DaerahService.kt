package com.example.submission_week_3.daerahPackage.network

import com.example.submission_week_3.daerahPackage.model.Daerah
import retrofit2.Call
import retrofit2.http.GET

interface DaerahService {
    @GET("propinsi.json")
    fun getDataDaerah(): Call<ArrayList<Daerah>>
}
