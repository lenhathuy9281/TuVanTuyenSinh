package com.doan.tuvantuyensinh.ui.target

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.TargetRepository
import com.doan.tuvantuyensinh.domain.TargetResponse
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class TargetViewModel @Inject constructor(
    private val targetRepository: TargetRepository,
    private val dispatchers: AppDispatchers
): ViewModel() {

    init {
        getTargets()
    }

    private var _targets: Flow<Resource<TargetResponse>> = flow {
        emit(Resource.loading())
        val response = targetRepository.getTargets()
        if (response.isSuccessful()){
            emit(Resource.success(response.data!!))
        } else {
            emit(Resource.error(response.error ?: Exception()))
        }
    }.flowOn(dispatchers.io)

    val targets: LiveData<Resource<TargetResponse>> get() = _targets.asLiveData()

    fun getTargets() {
        _targets = flow {
            emit(Resource.loading())
            val response = targetRepository.getTargets()
            if (response.isSuccessful()){
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: Exception()))
            }
        }.flowOn(dispatchers.io)
    }
}