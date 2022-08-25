package com.example.recipeapp.repository

import androidx.lifecycle.LiveData
import com.example.recipeapp.api.ApiService
import com.example.recipeapp.models.Recipe
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getRecipe()=apiService.getRecipe()

}