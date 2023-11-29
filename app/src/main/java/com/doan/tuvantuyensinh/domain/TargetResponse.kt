package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class TargetResponse(@SerializedName("targets") val targets: List<Target>?) {
}

class Target(
    @SerializedName("id") val id: String?,
    @SerializedName("nam") val nam: String?,
    @SerializedName("soLuong") val soLuong: String?,
    @SerializedName("phuongThuc") val phuongThuc: String?
)