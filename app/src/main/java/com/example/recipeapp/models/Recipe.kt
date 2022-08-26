package com.example.recipeapp.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(

	@SerializedName("thumbnail")
	val thumbnail: String?,
	@SerializedName("ingredients")
	val ingredients: String,
	@SerializedName("href")
	val href: String?,
	@SerializedName("title")
	val title: String?
): Parcelable

