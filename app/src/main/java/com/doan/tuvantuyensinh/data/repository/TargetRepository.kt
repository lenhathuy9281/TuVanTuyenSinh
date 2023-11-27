package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.data.remote.TargetService
import com.doan.tuvantuyensinh.domain.TargetResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import javax.inject.Inject

interface TargetRepository {
    suspend fun getTargets(): Resource<TargetResponse>
}

class TargetRepositoryImpl @Inject constructor(private val targetService: TargetService) : TargetRepository {
    override suspend fun getTargets(): Resource<TargetResponse> {
        return targetService.getTargets()
    }
}