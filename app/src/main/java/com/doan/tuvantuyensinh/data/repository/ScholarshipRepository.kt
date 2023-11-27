package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.data.remote.ScholarService
import com.doan.tuvantuyensinh.domain.ScholarshipResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import javax.inject.Inject

interface ScholarshipRepository {
    suspend fun getScholarships(): Resource<ScholarshipResponse>
}

class ScholarshipRepositoryImpl @Inject constructor(private val scholarService: ScholarService) : ScholarshipRepository {
    override suspend fun getScholarships(): Resource<ScholarshipResponse> {
        return scholarService.getScholars()
    }
}