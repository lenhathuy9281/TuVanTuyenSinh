package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.data.repository.SchoolResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import retrofit2.http.GET

interface SchoolService {
    @GET("school")
    suspend fun getSchools(): Resource<SchoolResponse>
}