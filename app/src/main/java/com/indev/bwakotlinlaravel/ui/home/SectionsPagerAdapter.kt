package com.indev.bwakotlinlaravel.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.indev.bwakotlinlaravel.ui.home.newtaste.HomeNewTasteFragment
import com.indev.bwakotlinlaravel.ui.home.popular.HomePopularFragment
import com.indev.bwakotlinlaravel.ui.home.recommend.HomeRecommendFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "New Popular"
            1 -> "Popular"
            2 -> "Recommended"
            else -> ""
        }
    }

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {

        val fragment : Fragment
        when(position) {
            0 -> {
                fragment = HomeNewTasteFragment()
                return fragment
            }
            1 -> {
                fragment = HomePopularFragment()
                return fragment
            }
            2 -> {
                fragment = HomeRecommendFragment()
                return fragment
            }
            else -> {
                fragment = HomeNewTasteFragment()
                return fragment
            }
        }
    }
}