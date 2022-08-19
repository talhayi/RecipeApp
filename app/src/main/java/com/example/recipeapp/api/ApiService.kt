package com.example.recipeapp.api

import com.example.recipeapp.models.RecipeResponse
import com.example.recipeapp.models.RecipeResponseItem
import com.example.recipeapp.util.Util.END_POINT
import retrofit2.Response
import retrofit2.http.GET

class ApiService {

    @GET(END_POINT)
    suspend fun getRecipe():Response<RecipeResponse>? = null
}