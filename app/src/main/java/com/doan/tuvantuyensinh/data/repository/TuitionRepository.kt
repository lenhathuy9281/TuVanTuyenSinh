package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.data.remote.TuitionService
import com.doan.tuvantuyensinh.domain.TuitionResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import javax.inject.Inject

interface TuitionRepository {
    suspend fun getTuition(): Resource<TuitionResponse>
}

class TuitionRepositoryImpl @Inject constructor(private val tuitionService: TuitionService) : TuitionRepository {
    override suspend fun getTuition(): Resource<TuitionResponse> {
        return tuitionService.getTuition()
    }
}