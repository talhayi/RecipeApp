package com.example.recipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentHomeBinding
import com.example.recipeapp.databinding.FragmentWebViewBinding
import com.example.recipeapp.models.Recipe
import dagger.hilt.android.AndroidEntryPoint


class WebViewFragment : Fragment(R.layout.fragment_web_view) {

    private var _binding: FragmentWebViewBinding?=null
    private val binding get() = _binding!!
    private val args : WebViewFragmentArgs by navArgs()
    private lateinit var recipe: Recipe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe = args.recipeWebView
        showWebView()
    }

    private fun showWebView(){
        binding.recipeWebView.apply {
         webViewClient = WebViewClient()
            recipe.href?.let { loadUrl(it) }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}