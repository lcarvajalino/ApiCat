package com.prueba.apppp.rest

import com.prueba.apppp.Models.Cat
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("breeds/")
    fun getUser(): Call<List<Cat>>?
}