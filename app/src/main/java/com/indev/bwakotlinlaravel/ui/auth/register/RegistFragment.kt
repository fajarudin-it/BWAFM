package com.indev.bwakotlinlaravel.ui.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.indev.bwakotlinlaravel.R
import com.indev.bwakotlinlaravel.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_regist.*

class RegistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_regist, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_continue.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_registFragment_to_registAddressFragment, null)

            (activity as AuthActivity).toolbarRegistAddress()
        }
    }
}