package com.doan.tuvantuyensinh.domain

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("message")
    val text: String, val isSent: Boolean = false
)

data class MessageVoice(
    @SerializedName("message")
    val text: String, val isSent: Boolean = false
)