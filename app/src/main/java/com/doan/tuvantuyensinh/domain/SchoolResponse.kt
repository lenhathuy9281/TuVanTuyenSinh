package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

data class SchoolResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("thanhPho") val thanhPho: String?,
    @SerializedName("quan") val quan: String?,
    @SerializedName("duong") val duong: String?,
    @SerializedName("image") val image: String?
)
