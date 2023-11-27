package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class TuitionResponse(@SerializedName("tuition") val tuition: List<Tuition>?) {
}

class Tuition(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)