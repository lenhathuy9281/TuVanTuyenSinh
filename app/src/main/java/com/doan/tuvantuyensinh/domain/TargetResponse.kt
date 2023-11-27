package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class TargetResponse(@SerializedName("targets") val targets: List<TargetEntity>?) {
}

class TargetEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)