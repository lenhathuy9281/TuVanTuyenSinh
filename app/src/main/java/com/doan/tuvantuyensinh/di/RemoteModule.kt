package com.doan.tuvantuyensinh.di

import com.doan.tuvantuyensinh.data.remote.ChatBotService
import com.doan.tuvantuyensinh.data.remote.JobService
import com.doan.tuvantuyensinh.data.remote.ScholarService
import com.google.gson.Gson
import com.doan.tuvantuyensinh.data.remote.SchoolService
import com.doan.tuvantuyensinh.data.remote.TargetService
import com.doan.tuvantuyensinh.data.remote.TuitionService
import com.doan.tuvantuyensinh.utils.remote.CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {

    @Singleton
    @Provides
    fun provideHttpLogging() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
//            .addInterceptor(AuthInterceptor())
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()

    @Singleton
    @Provides
    fun provideGson() =
        Gson().newBuilder()
            .serializeNulls()
            .create()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://192.168.1.29:5001/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CallAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideSChoolService(retrofit: Retrofit) = retrofit.create(SchoolService::class.java)

    @Singleton
    @Provides
    fun provideChatBotService(retrofit: Retrofit) = retrofit.create(ChatBotService::class.java)

    @Singleton
    @Provides
    fun provideJobService(retrofit: Retrofit) = retrofit.create(JobService::class.java)

    @Singleton
    @Provides
    fun provideTargetService(retrofit: Retrofit) = retrofit.create(TargetService::class.java)

    @Singleton
    @Provides
    fun provideScholarService(retrofit: Retrofit) = retrofit.create(ScholarService::class.java)

    @Singleton
    @Provides
    fun provideTuitionsService(retrofit: Retrofit) = retrofit.create(TuitionService::class.java)
}