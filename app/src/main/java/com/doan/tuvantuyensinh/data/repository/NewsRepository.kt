package com.doan.tuvantuyensinh.data.repository

import com.doan.tuvantuyensinh.data.remote.NewsService
import com.doan.tuvantuyensinh.domain.News
import com.doan.tuvantuyensinh.domain.NewsResponse
import com.doan.tuvantuyensinh.utils.remote.Resource
import javax.inject.Inject

interface NewsRepository {
    suspend fun getNews(): Resource<NewsResponse>

    suspend fun getNewDetail(id: String): Resource<News>
}

class NewsRepositoryImpl @Inject constructor(private val newsService: NewsService) : NewsRepository {
    override suspend fun getNews(): Resource<NewsResponse> {
        return newsService.getNews()
    }

    override suspend fun getNewDetail(id: String): Resource<News> {
        return newsService.getNewDetail(id)
    }
}