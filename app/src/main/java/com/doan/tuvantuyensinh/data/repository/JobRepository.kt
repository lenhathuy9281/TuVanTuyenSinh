package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.data.remote.JobService
import com.doan.tuvantuyensinh.domain.JobResponse
import com.doan.tuvantuyensinh.utils.remote.Resource

interface JobRepository {
    suspend fun getJobs(): Resource<JobResponse>
}

class JobRepositoryImpl constructor(private val jobService: JobService) : JobRepository {
    override suspend fun getJobs(): Resource<JobResponse> {
        return jobService.getJobs()
    }
}