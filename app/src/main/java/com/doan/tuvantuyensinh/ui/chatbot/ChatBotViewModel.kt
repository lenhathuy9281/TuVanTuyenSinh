package com.doan.tuvantuyensinh.ui.chatbot

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.doan.tuvantuyensinh.data.repository.ChatBotRepository
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.NetworkException
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatBotViewModel @Inject constructor(
    private val chatBotRepository: ChatBotRepository,
    private val dispatchers: AppDispatchers
) : ViewModel() {
    private var _chatBotResponse: Flow<Resource<String?>> = flow {
        emit(Resource.loading())
        val response = chatBotRepository.getChatBotResponse()
        if (response.isSuccessful()) {
            emit(Resource.success(response.data))
        } else {
            emit(Resource.error(response.error ?: NetworkException()))
        }
    }
    val chatBotResponse: Flow<Resource<String?>> get() = _chatBotResponse


    private var _sendMp3: Flow<Resource<String?>> = flow {
        emit(Resource.loading())
    }
    val sendMp3: LiveData<Resource<String?>> get() = _sendMp3.asLiveData()

    fun uploadMp3(fileName: String) {

        viewModelScope.launch(dispatchers.io) {
            chatBotRepository.uploadMp3(fileName)
        }
//        _sendMp3 = flow {
//            chatBotRepository.uploadMp3(fileName)
//            emit(Resource.loading())
//            val response = chatBotRepository.uploadMp3(fileName)
//            if (response.isSuccessful()) {
//                emit(Resource.success(response.data))
//            } else {
//                emit(Resource.error(response.error ?: NetworkException()))
//            }
//        }.flowOn(dispatchers.io)
    }

}