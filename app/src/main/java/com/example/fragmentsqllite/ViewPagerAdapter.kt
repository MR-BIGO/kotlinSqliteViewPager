package com.example.fragmentsqllite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2


    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return FormFragment()
        }

        return ListFragment()
    }
}