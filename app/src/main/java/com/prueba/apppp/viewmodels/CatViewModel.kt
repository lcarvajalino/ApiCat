package com.prueba.apppp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.prueba.apppp.Models.Cat
import com.prueba.apppp.data.Repository


class CatViewModel : ViewModel() {

    private var userRepository: Repository? = null

    init {
        userRepository = Repository()
    }

    fun getCats(): LiveData<List<Cat>>? {
        return userRepository?.getCats()
    }


}