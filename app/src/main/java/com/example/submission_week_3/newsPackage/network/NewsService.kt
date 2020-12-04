package com.example.submission_week_3.newsPackage.network

import com.example.submission_week_3.newsPackage.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("v2/top-headlines?country=us&category=business&apiKey=d25ca2a698344b4c9d2a9cc3866b1673")
    fun getDataNews(): Call<ResponseServer>
}
