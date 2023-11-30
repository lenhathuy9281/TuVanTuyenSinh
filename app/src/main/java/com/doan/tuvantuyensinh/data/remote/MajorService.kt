package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.domain.MajorResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import retrofit2.http.GET

interface MajorService {
    @GET("major")
    suspend fun getMajors(): Resource<MajorResponse>
}