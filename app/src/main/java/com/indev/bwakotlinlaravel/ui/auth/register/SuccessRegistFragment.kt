package com.indev.bwakotlinlaravel.ui.auth.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.ui.MainActivity

class SuccessRegistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success_regist, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Handler().postDelayed({
            val auth = Intent(activity, MainActivity::class.java)
            startActivity(auth)
            activity?.finishAffinity()
        }, 3000)
    }
}