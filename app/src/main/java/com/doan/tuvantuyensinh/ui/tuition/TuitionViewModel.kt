package com.doan.tuvantuyensinh.ui.tuition

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.TuitionRepository
import com.doan.tuvantuyensinh.domain.TuitionResponse
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class TuitionViewModel @Inject constructor(
    private val tuitionRepository: TuitionRepository,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    init {
        getTuition()
    }

    private var _tuition: Flow<Resource<TuitionResponse>> = flow {
        emit(Resource.loading())
        val response = tuitionRepository.getTuition()
        if (response.isSuccessful()){
            emit(Resource.success(response.data!!))
        } else {
            emit(Resource.error(response.error ?: Exception()))
        }
    }.flowOn(dispatchers.io)

    val tuition: LiveData<Resource<TuitionResponse>> get() = _tuition.asLiveData()

    fun getTuition() {
        _tuition = flow {
            emit(Resource.loading())
            val response = tuitionRepository.getTuition()
            if (response.isSuccessful()){
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: Exception()))
            }
        }.flowOn(dispatchers.io)
    }
}