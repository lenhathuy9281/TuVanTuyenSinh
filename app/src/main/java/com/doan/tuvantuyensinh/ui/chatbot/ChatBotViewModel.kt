package com.doan.tuvantuyensinh.ui.chatbot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.doan.tuvantuyensinh.data.repository.ChatBotRepository
import com.doan.tuvantuyensinh.domain.Message
import com.doan.tuvantuyensinh.domain.MessageVoice
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
    private val _chatBotResponse: MutableLiveData<Resource<Message?>> = MutableLiveData()
    val chatBotResponse: LiveData<Resource<Message?>> get() = _chatBotResponse


    private val _sendMp3: MutableLiveData<Resource<MessageVoice?>> = MutableLiveData()
    val sendMp3: LiveData<Resource<MessageVoice?>> get() = _sendMp3

    fun uploadMp3(fileName: String) {

        viewModelScope.launch(dispatchers.io) {
            viewModelScope.launch(dispatchers.io) {
                _sendMp3.postValue(Resource.loading())
                try {
                    val response = chatBotRepository.uploadMp3(fileName)
                    if (response.status == Resource.Status.SUCCESS) {
                        _sendMp3.postValue(Resource.success(response.data))
                    } else {
                        _sendMp3.postValue(Resource.error(response.error ?: NetworkException()))
                    }
                } catch (e: Exception) {
                    _sendMp3.postValue(Resource.error(e))
                }
            }
        }
    }

    fun getChabotResponse(userText: String) {
        viewModelScope.launch(dispatchers.io) {
            _chatBotResponse.postValue(Resource.loading())
            try {
                val response = chatBotRepository.getChatBotResponse(userText)
                if (response.status == Resource.Status.SUCCESS) {
                    _chatBotResponse.postValue(Resource.success(response.data))
                } else {
                    _chatBotResponse.postValue(Resource.error(response.error ?: NetworkException()))
                }
            } catch (e: Exception) {
                _chatBotResponse.postValue(Resource.error(e))
            }
        }
    }

}