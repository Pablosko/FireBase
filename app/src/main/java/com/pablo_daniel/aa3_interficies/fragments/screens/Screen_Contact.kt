package com.pablo_daniel.aa3_interficies.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.pablo_daniel.aa3_interficies.R

class Screen_Contact : Fragment() {
    lateinit var fragmentView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.screen_contact, container, false)
        return fragmentView
    }
}