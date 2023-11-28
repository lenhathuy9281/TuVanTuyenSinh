package com.doan.tuvantuyensinh.ui.job

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.JobRepository
import com.doan.tuvantuyensinh.domain.JobResponse
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.NetworkException
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class JobViewModel @Inject constructor(
    private val jobRepository: JobRepository,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    init {
        getJobs()
    }

    private var _job: Flow<Resource<JobResponse?>> = flow {
        emit(Resource.loading())
        val response = jobRepository.getJobs()
        if (response.isSuccessful()){
            emit(Resource.success(response.data!!))
        } else {
            emit(Resource.error(response.error ?: NetworkException()))
        }
    }.flowOn(dispatchers.io)

    val job: LiveData<Resource<JobResponse?>> get() = _job.asLiveData()
    fun getJobs(){
        _job = flow {
            emit(Resource.loading())
            val response = jobRepository.getJobs()
            if (response.isSuccessful()){
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: NetworkException()))
            }
        }.flowOn(dispatchers.io)
    }
}