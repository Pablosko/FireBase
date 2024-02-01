package com.pablo_daniel.aa3_interficies.clases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.pablo_daniel.aa3_interficies.R

class navHost : Fragment() {

    companion object
    {
        private lateinit var Instance: navHost

        fun get() = Instance


    }

    lateinit var navHost : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_navhost, container,false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.AppNavigationHost) as NavHostFragment
        navHost = navHostFragment.navController

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}