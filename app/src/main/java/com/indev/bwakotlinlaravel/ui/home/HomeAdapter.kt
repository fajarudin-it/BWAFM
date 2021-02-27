package com.indev.bwakotlinlaravel.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.dummy.HomeModel
import kotlinx.android.synthetic.main.item_home_horizontal.view.*
import kotlinx.android.synthetic.main.item_home_horizontal.view.tvTittleHorizontal

class HomeAdapter (
        private val listData : List<HomeModel>,
        private val itemAdapterCallback: ItemAdapterCallback
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_horizontal, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    interface ItemAdapterCallback {
        fun onCLick(view : View, data:HomeModel)
    }

    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bind(data: HomeModel, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                tvTittleHorizontal.text = data.tittle
                rbFood.rating = data.rating

//                Glide.with(context)
//                        .load(data.src)
//                        .into(ivPoster)

                itemView.setOnClickListener {
                    itemAdapterCallback.onCLick(it, data)
                }
            }
        }
    }
}