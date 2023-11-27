package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.domain.JobResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import retrofit2.http.GET

interface JobService {
    @GET("job")
    suspend fun getJobs(): Resource<JobResponse>
}