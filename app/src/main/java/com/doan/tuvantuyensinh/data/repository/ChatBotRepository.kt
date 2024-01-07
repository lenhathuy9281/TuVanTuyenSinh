package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.domain.Message
import com.doan.tuvantuyensinh.domain.MessageVoice
import com.doan.tuvantuyensinh.utils.remote.Resource

interface ChatBotRepository {
    suspend fun getChatBotResponse(userText: String): Resource<Message>
    suspend fun uploadMp3(filePath: String): Resource<MessageVoice>
}