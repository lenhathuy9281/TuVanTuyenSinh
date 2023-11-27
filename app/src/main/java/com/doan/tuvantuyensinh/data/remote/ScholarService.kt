package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.domain.ScholarshipResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import retrofit2.http.GET

interface ScholarService {
    @GET("scholar")
    suspend fun getScholars(): Resource<ScholarshipResponse>
}