package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

class NewsResponse(
    @SerializedName("news") val news: List<News>?
)
data class News(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("fullDescription") val fullDescription: String?,
    @SerializedName("time") val time: String?,
    @SerializedName("shortDescription") val shortDescription: String?
)
