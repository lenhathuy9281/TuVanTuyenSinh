package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

data class ItemNews(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("summarize") val summarize: String?
)
