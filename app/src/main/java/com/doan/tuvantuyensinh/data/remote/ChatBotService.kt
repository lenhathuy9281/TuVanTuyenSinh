package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.domain.Message
import com.doan.tuvantuyensinh.domain.MessageVoice
import com.doan.tuvantuyensinh.utils.remote.Resource
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ChatBotService {
    @GET("/get_msg")
    suspend fun getChatBotResponse(@Query("msg") userText: String): Resource<Message>

    @Multipart
    @POST("upload")
    suspend fun uploadMp3(@Part file: MultipartBody.Part): Resource<MessageVoice>
}