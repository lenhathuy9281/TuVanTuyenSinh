package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.utils.remote.Resource
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ChatBotService {
    @POST("chatbot")
    suspend fun getChatBotResponse(): Resource<String>

    @Multipart
    @POST("upload")
    suspend fun uploadMp3(@Part file: MultipartBody.Part): Resource<String>
}