package com.doan.tuvantuyensinh.di

import com.doan.tuvantuyensinh.data.repository.ChatBotRepository
import com.doan.tuvantuyensinh.data.repository.ChatBotRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.SchoolRepository
import com.doan.tuvantuyensinh.data.repository.SchoolRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSchoolRepository(impl: SchoolRepositoryImpl): SchoolRepository

    @Singleton
    @Binds
    abstract fun bindChatBotRepository(impl: ChatBotRepositoryImpl): ChatBotRepository
}