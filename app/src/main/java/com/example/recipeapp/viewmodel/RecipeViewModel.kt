package com.example.recipeapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    application: Application,
    private val repository: RecipeRepository
): AndroidViewModel(application){
    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    init {
        getRecipe()
    }

    private fun getRecipe() = CoroutineScope(Dispatchers.IO).launch {
        repository.getRecipe().let { recipes ->
            if (recipes.isSuccessful){
                _recipes.postValue(recipes.body())
            }else{
                Toast.makeText(getApplication(),"Error: ${recipes.code()}", Toast.LENGTH_LONG).show()
            }
        }
    }
}