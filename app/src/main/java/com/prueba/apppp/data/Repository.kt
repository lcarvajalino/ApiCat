package com.prueba.apppp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prueba.apppp.Models.Cat
import com.prueba.apppp.rest.ApiClient.client
import com.prueba.apppp.rest.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private var apiService: ApiService? = null

    init {
        apiService = client!!.create(ApiService::class.java)
    }


    fun getCats(): LiveData<List<Cat>> {
        val data = MutableLiveData<List<Cat>>()
        apiService!!.getUser()!!.enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                if (response.isSuccessful) {
                    data.setValue(response.body())
                } else {
                    Log.e("ERROR","${response.errorBody()}" )
                }
            }
            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                Log.e("ERROR","ERROR EN LA CONSULTA" )
            }
        })
        return data
    }


}