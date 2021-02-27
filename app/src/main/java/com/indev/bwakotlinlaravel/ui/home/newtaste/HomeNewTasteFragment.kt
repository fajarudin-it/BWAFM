package com.indev.bwakotlinlaravel.ui.home.newtaste

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

class HomeNewTasteFragment : Fragment(), HomeNewTasteAdapter.ItemAdapterCallback {

    private var foodList : ArrayList<HomeVerticalModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_new_taste, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        val adapter = HomeNewTasteAdapter(foodList,this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcListVertical.layoutManager = layoutManager
        rcListVertical.adapter = adapter

    }

    fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeVerticalModel("Cherry Healthy","10000", "",5f))
        foodList.add(HomeVerticalModel("Burger Tamayo","25000", "",4f))
        foodList.add(HomeVerticalModel("Sandwitch Yummy","15000", "",3.5f))
        foodList.add(HomeVerticalModel("Cilok Bandung","10000", "",4.5f))
    }

    override fun onCLick(view: View, data: HomeVerticalModel) {
        Toast.makeText(context, "Test klik item"+data.tittle, Toast.LENGTH_SHORT).show()
    }
}