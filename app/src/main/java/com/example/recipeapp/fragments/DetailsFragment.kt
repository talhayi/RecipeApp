package com.example.recipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentDetailsBinding
import com.example.recipeapp.databinding.FragmentHomeBinding
import com.example.recipeapp.models.Recipe
import dagger.hilt.android.AndroidEntryPoint


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding?=null
    private val binding get() = _binding!!
    private val args : DetailsFragmentArgs by navArgs()
    private lateinit var recipe: Recipe


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe = args.recipe

        showDetail()

    }

    private fun showDetail(){
        binding.apply {
            //DataBinding is used
            detailRecipe = recipe
            /*
            titleTextView.text = recipe.title
            ingredientsTextView.text = recipe.ingredients
            detailImageView.load(recipe.thumbnail){
                crossfade(true)
                crossfade(1000)
            }
             */
            button.setOnClickListener{
                val action = DetailsFragmentDirections.actionDetailsFragmentToWebViewFragment(recipe)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}