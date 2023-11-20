package com.doan.tuvantuyensinh.data.repository

import androidx.core.content.ContextCompat
import com.doan.tuvantuyensinh.data.remote.ChatBotService
import com.doan.tuvantuyensinh.utils.remote.Resource
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class ChatBotRepositoryImpl @Inject constructor(private val chatBotService: ChatBotService): ChatBotRepository {
    override suspend fun getChatBotResponse(): Resource<String> {
        return chatBotService.getChatBotResponse()
    }

    override suspend fun uploadMp3(filePath: String): Resource<String> {
        val file = File(filePath)
        val requestFile = RequestBody.create("audio/mpeg".toMediaTypeOrNull(), file)
        val filePart = MultipartBody.Part.createFormData("file", file.name, requestFile)

        return chatBotService.uploadMp3(filePart)
    }
}