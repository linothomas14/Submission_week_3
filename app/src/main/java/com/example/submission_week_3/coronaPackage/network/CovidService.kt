package com.example.submission_week_3.coronaPackage.network

import com.example.submission_week_3.coronaPackage.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface CovidService {

    @GET("public/api/prov.json")
    fun getDataCovid():Call<ResponseServer>

}
