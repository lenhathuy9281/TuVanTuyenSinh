package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.utils.remote.Resource

interface ChatBotRepository {
    suspend fun getChatBotResponse(): Resource<String>
    suspend fun uploadMp3(filePath: String): Resource<String>
}