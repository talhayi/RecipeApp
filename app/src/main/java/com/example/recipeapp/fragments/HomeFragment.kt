package com.example.recipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipeapp.R
import com.example.recipeapp.adapter.RecipeAdapter
import com.example.recipeapp.databinding.FragmentHomeBinding
import com.example.recipeapp.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding
    private val viewModel:RecipeViewModel by viewModels()
    private lateinit var recipeAdapter: RecipeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRV()
    }

    private fun setupRV(){

        recipeAdapter = RecipeAdapter()
        binding?.recyclerView?.apply {
            layoutManager = GridLayoutManager(context,2)
            setHasFixedSize(true)
            adapter = recipeAdapter
        }

        viewModel.recipes.observe(viewLifecycleOwner, Observer { recipes->

            recipes?.let {
                recipeAdapter.recipe = recipes
            }

        })
/*
        viewModel.recipes.observe(requireActivity()) { recipes ->
            recipeAdapter.recipe = recipes

        }

 */
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}