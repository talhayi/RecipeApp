package com.example.recipeapp.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Util {
    const val BASE_URL = "http://yazilimgunlukleri.com/"
    const val END_POINT = "RecipeApp/recipes.json"

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
}