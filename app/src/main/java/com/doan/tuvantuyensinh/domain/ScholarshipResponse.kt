package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class ScholarshipResponse(@SerializedName("scholarships") val scholarships: List<Scholarship>?) {
}

class Scholarship(
    @SerializedName("id") val id: String?,
    @SerializedName("loaiHb") val loaiHb: String?,
    @SerializedName("diemYc") val diemYc: String?,
    @SerializedName("hanhKiemYc") val hanhKiemYc: String?
)