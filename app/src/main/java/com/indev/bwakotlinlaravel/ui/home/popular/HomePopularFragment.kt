package com.indev.bwakotlinlaravel.ui.home.popular

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

class HomePopularFragment : Fragment(), HomePopularAdapter.ItemAdapterCallback {

    private var foodList : ArrayList<HomeVerticalModel> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_popular, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        val adapter = HomePopularAdapter(foodList,this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcListVertical.layoutManager = layoutManager
        rcListVertical.adapter = adapter
    }

    private fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeVerticalModel("Cherry Healthy","70000", "",3f))
        foodList.add(HomeVerticalModel("Burger Tamayo","30000", "",5f))
        foodList.add(HomeVerticalModel("Sandwitch Yummy","25000", "",4.5f))
    }

    override fun onCLick(view: View, data: HomeVerticalModel) {
        Toast.makeText(context, "Test klik item"+data.tittle, Toast.LENGTH_SHORT).show()
    }
}