package com.indev.bwakotlinlaravel.ui.home.newtaste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.dummy.HomeVerticalModel
import com.indev.bwakotlinlaravel.utils.Helpers.formatPrice
import kotlinx.android.synthetic.main.item_home_vertical.view.*

class HomeNewTasteAdapter (
        private val listData : List<HomeVerticalModel>,
        private val itemAdapterCallback: ItemAdapterCallback
) : RecyclerView.Adapter<HomeNewTasteAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewTasteAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_vertical, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    interface ItemAdapterCallback {
        fun onCLick(view : View, data:HomeVerticalModel)
    }

    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bind(data: HomeVerticalModel, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                tvTittleVertical.text = data.tittle
                tvPrice.formatPrice (data.price)
                rbFoodVertical.rating = data.rating

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