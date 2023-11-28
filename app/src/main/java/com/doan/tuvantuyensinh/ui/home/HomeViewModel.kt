package com.doan.tuvantuyensinh.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.SchoolRepository
import com.doan.tuvantuyensinh.domain.SchoolResponse
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.NetworkException
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository,
    private val dispatchers: AppDispatchers
): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
//    val text: LiveData<String> = _text
//
//    val username = MutableLiveData("")
//    val password = MutableLiveData("")
//
//    fun login(){
//        val username = username.value
//        val password = password.value
//        Timber.d("username: $username")
//        Timber.d("password: $password")
//    }

}