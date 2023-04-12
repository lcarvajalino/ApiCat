package com.prueba.apppp.Models

import com.google.gson.annotations.SerializedName

data class Cat(
    val name: String = "",
    val origin: String = "",
    val affectionLevel: Int = 0,
    val intelligence: Int = 0,
    @SerializedName("reference_image_id") val imageUrl: String = ""
)