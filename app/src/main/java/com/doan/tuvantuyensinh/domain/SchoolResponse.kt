package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

data class SchoolResponse(
    @SerializedName("school") val school: School?
)

class School(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("address") val address: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String,
    @SerializedName("website") val website: String,
    @SerializedName("tuition") val tuition: String,
    @SerializedName("target") val target: String,
    @SerializedName("job") val job: String,
    @SerializedName("scholar") val scholar: String
)
