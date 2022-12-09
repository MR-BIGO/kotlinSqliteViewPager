package com.example.fragmentsqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentsqllite.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val tabLayout = binding.tabLayout
        val viewPager = binding.pager
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = "Form ${position + 1}"
        }.attach()
    }
}