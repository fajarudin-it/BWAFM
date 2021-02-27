package com.indev.bwakotlinlaravel.ui.splashscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.indev.bwakotlinlaravel.R

class IntroSliderAdapter(private val introSlides: List<IntroSlider>) :
    RecyclerView.Adapter<IntroSliderAdapter.introSliderViewHolder> () {

    inner class introSliderViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)
        private val imageIcon = view.findViewById<ImageView>(R.id.imageSlide)

        fun bind(introSlider: IntroSlider) {
            textTitle.text = introSlider.title
            textDescription.text = introSlider.description
            imageIcon.setImageResource(introSlider.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): introSliderViewHolder {
        return introSliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return  introSlides.size
    }

    override fun onBindViewHolder(holder: introSliderViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }
}