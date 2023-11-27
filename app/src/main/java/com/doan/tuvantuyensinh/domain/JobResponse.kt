package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class JobResponse(@SerializedName("job") val job: List<Job>) {
}
class Job(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)