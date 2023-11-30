package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class MajorResponse(@SerializedName("majors") val majors: List<Major>?) {
}

data class Major(
    @SerializedName("id") val id: String?,
    @SerializedName("ten_nganh") val tenNganh: String?,
    @SerializedName("ma_nganh") val maNganh: String?,
    @SerializedName("mo_ta") val moTa: String?,
    @SerializedName("soTin") val soTin: String?,
    @SerializedName("co_so") val coSo: String?
)