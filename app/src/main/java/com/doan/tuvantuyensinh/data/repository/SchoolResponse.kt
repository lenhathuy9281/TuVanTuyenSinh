package com.doan.tuvantuyensinh.data.repository

import com.google.gson.annotations.SerializedName

data class SchoolResponse(
    @SerializedName("school") val school: String? = ""
)
