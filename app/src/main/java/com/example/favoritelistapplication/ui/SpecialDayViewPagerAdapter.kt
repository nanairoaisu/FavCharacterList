package com.example.favoritelistapplication.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.favoritelistapplication.ui.anniversary.AnniversaryFragment
import com.example.favoritelistapplication.ui.birthday.BirthdayFragment
import java.lang.IndexOutOfBoundsException

const val BIRTHDAY_PAGE_INDEX = 0
const val ANNIVERSARY_PAGE_INDEX = 1

class SpecialDayViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
        BIRTHDAY_PAGE_INDEX to { BirthdayFragment() },
        ANNIVERSARY_PAGE_INDEX to { AnniversaryFragment() }
    )

    override fun getItemCount(): Int = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}