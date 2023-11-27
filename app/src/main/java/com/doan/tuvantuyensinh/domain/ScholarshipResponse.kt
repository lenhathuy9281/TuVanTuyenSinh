package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class ScholarshipResponse(@SerializedName("scholarship") val scholarship: List<Scholarship>?) {
}

class Scholarship(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)