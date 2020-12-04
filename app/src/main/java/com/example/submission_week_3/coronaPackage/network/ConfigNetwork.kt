package com.example.submission_week_3.coronaPackage.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getRetrofit(): CovidService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(CovidService::class.java)
            return service

        }


    }

}