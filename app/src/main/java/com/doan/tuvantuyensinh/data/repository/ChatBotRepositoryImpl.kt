package com.doan.tuvantuyensinh.data.repository

import androidx.core.content.ContextCompat
import com.doan.tuvantuyensinh.data.remote.ChatBotService
import com.doan.tuvantuyensinh.domain.Message
import com.doan.tuvantuyensinh.domain.MessageVoice
import com.doan.tuvantuyensinh.utils.remote.Resource
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class ChatBotRepositoryImpl @Inject constructor(private val chatBotService: ChatBotService): ChatBotRepository {
    override suspend fun getChatBotResponse(userText: String): Resource<Message> {
        return chatBotService.getChatBotResponse(userText)
    }

    override suspend fun uploadMp3(filePath: String): Resource<MessageVoice> {
        val file = File(filePath)
        val requestFile = RequestBody.create("audio/mpeg".toMediaTypeOrNull(), file)
        val filePart = MultipartBody.Part.createFormData("file", file.name, requestFile)

        return chatBotService.uploadMp3(filePart)
    }
}