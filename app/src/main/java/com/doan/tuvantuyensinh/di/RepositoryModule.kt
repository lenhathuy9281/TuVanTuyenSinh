package com.doan.tuvantuyensinh.di

import com.doan.tuvantuyensinh.data.repository.ChatBotRepository
import com.doan.tuvantuyensinh.data.repository.ChatBotRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.JobRepository
import com.doan.tuvantuyensinh.data.repository.JobRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.MajorRepository
import com.doan.tuvantuyensinh.data.repository.MajorRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.NewsRepository
import com.doan.tuvantuyensinh.data.repository.NewsRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.ScholarshipRepository
import com.doan.tuvantuyensinh.data.repository.ScholarshipRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.SchoolRepository
import com.doan.tuvantuyensinh.data.repository.SchoolRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.TargetRepository
import com.doan.tuvantuyensinh.data.repository.TargetRepositoryImpl
import com.doan.tuvantuyensinh.data.repository.TuitionRepository
import com.doan.tuvantuyensinh.data.repository.TuitionRepositoryImpl
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

    @Singleton
    @Binds
    abstract fun bindJobRepository(impl: JobRepositoryImpl): JobRepository

    @Singleton
    @Binds
    abstract fun bindTuitionRepository(impl: TuitionRepositoryImpl): TuitionRepository

    @Singleton
    @Binds
    abstract fun bindScholarshipRepository(impl: ScholarshipRepositoryImpl): ScholarshipRepository

    @Singleton
    @Binds
    abstract fun bindTargetRepository(impl: TargetRepositoryImpl): TargetRepository

    @Singleton
    @Binds
    abstract fun bindMajorRepository(impl: MajorRepositoryImpl): MajorRepository

    @Singleton
    @Binds
    abstract fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository
}