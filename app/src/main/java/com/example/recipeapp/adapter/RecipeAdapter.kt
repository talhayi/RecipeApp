package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recipeapp.databinding.FragmentHomeBinding
import com.example.recipeapp.databinding.ItemRecipeRowBinding
import com.example.recipeapp.fragments.HomeFragmentDirections
import com.example.recipeapp.models.Recipe

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(val binding: ItemRecipeRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
            return newItem == oldItem
        }
    }
    private val differ = AsyncListDiffer(this,diffCallBack)
    var recipe:List<Recipe>
        get() = differ.currentList
        set(value){
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(ItemRecipeRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipe[position]
        holder.binding.apply {
            textView.text=currentRecipe.title
            imageView.load(currentRecipe.thumbnail){
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(currentRecipe)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return recipe.size
    }

}