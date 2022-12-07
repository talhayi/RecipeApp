package com.example.recipeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 import android.widget.Toast
import com.example.recipeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}