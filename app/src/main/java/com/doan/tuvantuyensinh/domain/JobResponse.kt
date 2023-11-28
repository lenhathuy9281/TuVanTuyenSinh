package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class JobResponse(@SerializedName("jobs") val jobs: List<Job>) {
}
class Job(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("salary") val salary: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("description") val description: String?,
)