package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.domain.TuitionResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import retrofit2.http.GET

interface TuitionService {
    @GET("tuition")
    suspend fun getTuition(): Resource<TuitionResponse>
}