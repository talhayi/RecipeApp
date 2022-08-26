package com.example.recipeapp.di

import com.example.recipeapp.api.ApiService
import com.example.recipeapp.util.Util.BASE_URL
import com.example.recipeapp.util.Util.client

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofitInstance():ApiService =
             Retrofit.Builder()
            .baseUrl(BASE_URL)
                 .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


}