package com.example.githubsearchapp.UI.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubsearchapp.R
import com.example.githubsearchapp.databinding.ActivityMainBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}