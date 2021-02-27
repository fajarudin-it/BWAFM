package com.indev.bwakotlinlaravel.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.ui.auth.AuthActivity
import com.indev.bwakotlinlaravel.ui.auth.login.LoginFragment

class OnboardingOneActivity : AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlider(
                "Main Food",
                "Seems like you have not\n" +
                        "ordered any food yet",
                R.drawable.ic_empty_order
            ),
            IntroSlider(
                "Free Order",
                "Now you are able to order\n" +
                        "some foods as a self-reward",
                R.drawable.ic_signup_success
            ),
            IntroSlider(
                "Delivery",
                "Just stay at home while we are\n" +
                        "preparing your best foods",
                R.drawable.ic_success_order
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)


        val buttonNext = findViewById<Button>(R.id.buttonNext)
        val introSliderViewPager = findViewById<ViewPager2>(R.id.introSliderViewPager)
        val textSkipIntro = findViewById<TextView>(R.id.textSkipIntro)

        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })


        buttonNext.setOnClickListener {
            if (introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                introSliderViewPager.currentItem += 1
            } else {
                Intent(applicationContext, AuthActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        textSkipIntro.setOnClickListener {
            Intent(applicationContext, AuthActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun setupIndicators() {

        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }

            val indicatorContainer = findViewById<LinearLayout>(R.id.indicatorContainer)
            indicatorContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {

        val indicatorContainer = findViewById<LinearLayout>(R.id.indicatorContainer)

        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}