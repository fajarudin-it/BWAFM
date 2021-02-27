package com.indev.bwakotlinlaravel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.dummy.HomeModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeAdapter.ItemAdapterCallback {

    private var foodList : ArrayList<HomeModel> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        val adapter = HomeAdapter(foodList,this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcListHorizontal.layoutManager = layoutManager
        rcListHorizontal.adapter = adapter

        val sectionsPagerAdapter = SectionsPagerAdapter(
            childFragmentManager
        )
        viewPagerHome.adapter = sectionsPagerAdapter
        tabLayoutHome.setupWithViewPager(viewPagerHome)


    }

    fun initDataDummy() {
        foodList = ArrayList()
            foodList.add(HomeModel("Cherry Healthy","",5f))
            foodList.add(HomeModel("Burger Tamayo","",4f))
            foodList.add(HomeModel("Sandwitch Yummy","",3.5f))
        }

    override fun onCLick(view: View, data: HomeModel) {
        Toast.makeText(context, "test click", Toast.LENGTH_LONG).show()
    }

}