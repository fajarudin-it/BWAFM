package com.indev.bwakotlinlaravel.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.dummy.ProfileMenuModel
import kotlinx.android.synthetic.main.item_menu_profile.view.*

class ProfileMenuAdapter (
    private val listData : List<ProfileMenuModel>,
    private val itemAdapterCallback: ItemAdapterCallback
) : RecyclerView.Adapter<ProfileMenuAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileMenuAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_menu_profile, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    interface ItemAdapterCallback {
        fun onCLick(view : View, data:ProfileMenuModel)
    }

    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bind(data: ProfileMenuModel, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                tvTittle.text = data.tittle

                itemView.setOnClickListener {
                    itemAdapterCallback.onCLick(it, data)
                }
            }
        }
    }
}