package com.indev.bwakotlinlaravel.ui.home.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.dummy.HomeVerticalModel
import kotlinx.android.synthetic.main.fragment_home_new_taste.*

class HomeRecommendFragment : Fragment(), HomeRecommendAdapter.ItemAdapterCallback {

    private var foodList : ArrayList<HomeVerticalModel> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_recommend, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        val adapter = HomeRecommendAdapter(foodList,this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcListVertical.layoutManager = layoutManager
        rcListVertical.adapter = adapter
    }

    private fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeVerticalModel("Cherry Healthy","60000", "",4f))
        foodList.add(HomeVerticalModel("Burger Tamayo","12000", "",2f))
        foodList.add(HomeVerticalModel("Sandwitch Yummy","50000", "",4f))
    }

    override fun onCLick(view: View, data: HomeVerticalModel) {
        Toast.makeText(context, "Test klik item"+data.tittle, Toast.LENGTH_SHORT).show()
    }
}