package com.example.recipeapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.recipeapp.models.RecipeResponse
import com.example.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    application: Application,
    private val repository: RecipeRepository
): AndroidViewModel(application){
    private val _response = MutableLiveData<RecipeResponse>()
    val responceRecipe: LiveData<RecipeResponse>
        get() = _response

    init {
        getRecipe()
    }

    private fun getRecipe() = viewModelScope.launch {
        repository.getRecipe().let { response ->
            if (response != null) {
                if (response.isSuccessful){
                    _response.postValue(response.body())
                }else{
                    Toast.makeText(getApplication(),"Error: ${response.code()}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}