package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.domain.TargetResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import retrofit2.http.GET

interface TargetService {
    @GET("target")
    suspend fun getTargets(): Resource<TargetResponse>
}