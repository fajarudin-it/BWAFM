package com.indev.bwakotlinlaravel.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.indev.bwakotlinlaravel.ui.profile.account.ProfileAccountFragment
import com.indev.bwakotlinlaravel.ui.profile.foodmarket.ProfileFoodmarketFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter (fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Account"
            1 -> "FoodMarket"
            else -> ""
        }
    }


    override fun getCount(): Int = 2


    override fun getItem(position: Int): Fragment {

        val fragment : Fragment
        when(position) {
            0 -> {
                fragment = ProfileAccountFragment()
                return fragment
            }
            1 -> {
                fragment = ProfileFoodmarketFragment()
                return fragment
            }
            else -> {
                fragment = ProfileAccountFragment()
                return fragment
            }
        }
    }
}