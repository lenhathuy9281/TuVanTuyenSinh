package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.domain.SchoolResponse
import com.doan.tuvantuyensinh.utils.remote.Resource

interface SchoolRepository {
    suspend fun getSchools(): Resource<SchoolResponse>
}