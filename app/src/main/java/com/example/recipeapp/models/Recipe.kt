package com.example.recipeapp.models


import com.google.gson.annotations.SerializedName

data class Recipe(

	@SerializedName("thumbnail")
	val thumbnail: String?,
	@SerializedName("ingredients")
	val ingredients: String,
	@SerializedName("href")
	val href: String?,
	@SerializedName("title")
	val title: String?
)

