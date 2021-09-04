package com.example.favoritelistapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.favoritelistapplication.R
import com.example.favoritelistapplication.databinding.FragmentSpecialDayViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialDayViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSpecialDayViewPagerBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabs

        viewPager.adapter = SpecialDayViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()


        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            BIRTHDAY_PAGE_INDEX -> getString(R.string.title_birthday)
            ANNIVERSARY_PAGE_INDEX -> getString(R.string.title_anniversary)
            else -> null
        }
    }

}