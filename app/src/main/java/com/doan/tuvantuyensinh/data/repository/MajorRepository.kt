package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.data.remote.JobService
import com.doan.tuvantuyensinh.data.remote.MajorService
import com.doan.tuvantuyensinh.domain.MajorResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import javax.inject.Inject

interface MajorRepository {
    suspend fun getMajors(): Resource<MajorResponse>
}

class MajorRepositoryImpl @Inject constructor(private val majorService: MajorService) : MajorRepository {
    override suspend fun getMajors(): Resource<MajorResponse> {
        return majorService.getMajors()
    }
}