package com.doan.tuvantuyensinh.ui.school

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
import javax.inject.Inject

@HiltViewModel
class SchoolInfoViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository,
    private val dispatchers: AppDispatchers
)  : ViewModel() {

    init {
        getSchools()
    }

    private var _school: Flow<Resource<SchoolResponse?>> = flow {
        emit(Resource.loading())
        val response = schoolRepository.getSchools()
        if (response.isSuccessful()){
            emit(Resource.success(response.data))
        } else {
            emit(Resource.error(response.error ?: NetworkException()))
        }
    }.flowOn(dispatchers.io)

    val school: LiveData<Resource<SchoolResponse?>> get() = _school.asLiveData()

    fun getSchools(){
        _school = flow {
            emit(Resource.loading())
            val response = schoolRepository.getSchools()
            if (response.isSuccessful()){
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: NetworkException()))
            }
        }.flowOn(dispatchers.io)

    }

}