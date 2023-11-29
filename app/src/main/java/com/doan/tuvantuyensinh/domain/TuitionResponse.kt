package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class TuitionResponse(@SerializedName("tuitions") val tuition: List<Tuition>?) {
}

class Tuition(
    @SerializedName("id") val id: String?,
    @SerializedName("soTien") val soTien: String?,
    @SerializedName("namHoc") val namHoc: String?,
)