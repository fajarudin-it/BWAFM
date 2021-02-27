package com.indev.bwakotlinlaravel.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.indev.bwakotlinlaravel.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val pageRequest = intent.getIntExtra("page_request", 0)
        if (pageRequest == 1) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.loginFragment, true)
                .build()

            Navigation.findNavController(findViewById(R.id.authNavHost))
                .navigate(R.id.action_loginFragment_to_registFragment, null, navOptions)

            toolbarRegist()
        }
    }

    fun toolbarRegist() {
        toolbar.title = "Register"
        toolbar.subtitle = "Register and eat"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener{onBackPressed()}
    }
    fun toolbarRegistAddress() {
        toolbar.title = "Address"
        toolbar.subtitle = "Make sure it's valid"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener{onBackPressed()}
    }
    fun toolbarRegistSuccess() {
        toolbar.visibility = View.GONE
    }
}