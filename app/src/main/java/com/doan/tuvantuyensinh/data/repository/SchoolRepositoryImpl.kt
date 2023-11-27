package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.data.remote.SchoolService
import com.doan.tuvantuyensinh.domain.SchoolResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import javax.inject.Inject

class SchoolRepositoryImpl @Inject constructor(private val schoolService: SchoolService): SchoolRepository {
    override suspend fun getSchools(): Resource<SchoolResponse> {
        return schoolService.getSchools()
    }
}