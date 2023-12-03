package com.doan.tuvantuyensinh.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doan.tuvantuyensinh.data.repository.NewsRepository
import com.doan.tuvantuyensinh.domain.News
import com.doan.tuvantuyensinh.utils.AppDispatchers
import com.doan.tuvantuyensinh.utils.remote.NetworkException
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class DetailNewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val dispatchers: AppDispatchers,
) : ViewModel() {
    private var _news : Flow<Resource<News>>? = null

    val news: LiveData<Resource<News>>
        get() = _news?.asLiveData()!!
    fun getNewsDetail(id: String) {
        _news = flow {
            emit(Resource.loading())
            val response = newsRepository.getNewDetail(id)
            if (response.status == Resource.Status.SUCCESS) {
                emit(Resource.success(response.data!!))
            } else {
                emit(Resource.error(response.error ?: NetworkException()))
            }
        }.flowOn(dispatchers.io)
    }
}