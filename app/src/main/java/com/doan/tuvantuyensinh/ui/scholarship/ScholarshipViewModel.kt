package com.doan.tuvantuyensinh.ui.scholarship

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.ScholarshipRepository
import com.doan.tuvantuyensinh.domain.ScholarshipResponse
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class ScholarshipViewModel @Inject constructor(
    private val scholarshipRepository: ScholarshipRepository,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    init {
        getScholarships()
    }

    private var _scholarship: Flow<Resource<ScholarshipResponse>> = flow {
        emit(Resource.loading())
        val response = scholarshipRepository.getScholarships()
        if (response.isSuccessful()){
            emit(Resource.success(response.data!!))
        } else {
            emit(Resource.error(response.error ?: Exception()))
        }
    }.flowOn(dispatchers.io)

    val scholarship: LiveData<Resource<ScholarshipResponse>> get() = _scholarship.asLiveData()

    fun getScholarships(){
        _scholarship = flow {
            emit(Resource.loading())
            val response = scholarshipRepository.getScholarships()
            if (response.isSuccessful()){
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: Exception()))
            }
        }.flowOn(dispatchers.io)
    }
}