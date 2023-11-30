package com.doan.tuvantuyensinh.ui.major

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.MajorRepository
import com.doan.tuvantuyensinh.domain.MajorResponse
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.NetworkException
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MajorViewModel @Inject constructor(
    private val majorRepository: MajorRepository,
    private val dispatchers: AppDispatchers
): ViewModel() {

    init {
        getMajors()
    }

    private var _majors: Flow<Resource<MajorResponse>> = flow {
        emit(Resource.loading())
        val response = majorRepository.getMajors()
        if (response.isSuccessful()){
            emit(Resource.success(response.data!!))
        } else {
            emit(Resource.error(response.error ?: NetworkException()))
        }
    }.flowOn(dispatchers.io)

    val majors: LiveData<Resource<MajorResponse>>
        get() = _majors.asLiveData()

    fun getMajors() {
        _majors = flow {
            emit(Resource.loading())
            val response = majorRepository.getMajors()
            if (response.isSuccessful()){
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: NetworkException()))
            }
        }.flowOn(dispatchers.io)
    }

}