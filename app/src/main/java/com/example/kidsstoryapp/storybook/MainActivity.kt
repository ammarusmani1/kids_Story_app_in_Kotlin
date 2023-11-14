package com.example.kidsstoryapp.storybook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kidsstoryapp.databinding.ActivityMainBinding
import com.example.kidsstoryapp.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

   private lateinit var Adapter:StoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val storyList = Constants.getStoryList()
        binding.rvStoryList.layoutManager= LinearLayoutManager(this)
        Adapter=StoryAdapter(storyList)
        binding.rvStoryList.adapter=Adapter

    }
}
