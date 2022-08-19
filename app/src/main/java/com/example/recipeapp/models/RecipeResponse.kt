package com.example.recipeapp.models

data class RecipeResponse(
	val recipeResponse: List<RecipeResponseItem?>? = null
)

data class RecipeResponseItem(
	val thumbnail: String? = null,
	val ingredients: String? = null,
	val href: String? = null,
	val title: String? = null
)

