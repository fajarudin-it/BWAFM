package com.indev.bwakotlinlaravel.ui.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.ui.MainActivity
import com.indev.bwakotlinlaravel.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_regist.setOnClickListener {
            val login = Intent(activity, AuthActivity::class.java)
            login.putExtra("page_request", 1)
            startActivity(login)
        }

        btn_login.setOnClickListener {
            val home = Intent(activity, MainActivity::class.java)
            startActivity(home)
            activity?.finish()
        }
    }
}