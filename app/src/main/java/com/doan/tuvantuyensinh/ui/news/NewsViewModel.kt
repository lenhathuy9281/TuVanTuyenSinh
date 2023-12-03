package com.doan.tuvantuyensinh.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.NewsRepository
import com.doan.tuvantuyensinh.domain.NewsResponse
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.NetworkException
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val dispatchers: AppDispatchers,
): ViewModel() {

    init {
        getNews()
    }

    private var _news: Flow<Resource<NewsResponse>> = flow {
        emit(Resource.loading())
        val response = newsRepository.getNews()
        if (response.status == Resource.Status.SUCCESS) {
            emit(Resource.success(response.data!!))
        } else {
            emit(Resource.error(response.error ?: NetworkException()))
        }
    }.flowOn(dispatchers.io)

    val news: LiveData<Resource<NewsResponse>>
        get() = _news.asLiveData()

    fun getNews() {
        _news = flow {
            emit(Resource.loading())
            val response = newsRepository.getNews()
            if (response.status == Resource.Status.SUCCESS) {
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: NetworkException()))
            }
        }.flowOn(dispatchers.io)
    }
}