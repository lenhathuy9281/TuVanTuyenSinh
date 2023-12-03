package com.doan.tuvantuyensinh.data.remote

import com.doan.tuvantuyensinh.domain.News
import com.doan.tuvantuyensinh.domain.NewsResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("news")
    suspend fun getNews(): Resource<NewsResponse>

    @GET("/news/detail")
    suspend fun getNewDetail(@Query("id") id: String): Resource<News>
}