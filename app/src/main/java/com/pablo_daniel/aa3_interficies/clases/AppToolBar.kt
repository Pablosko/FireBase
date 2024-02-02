package com.pablo_daniel.aa3_interficies.clases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.pablo_daniel.aa3_interficies.R
import com.pablo_daniel.aa3_interficies.firebase.FB

class AppToolBar: Fragment() {
    companion object{
        private lateinit var Instance: AppToolBar
        fun get() = Instance
    }

    lateinit var  toolBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance =this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_toolbar, container, false)
        toolBar= view.findViewById(R.id.AppToolBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar.setNavigationOnClickListener{
            AppDrawer.get().openDrawer()
        }
        toolBar.setOnMenuItemClickListener{ menuItem->
            when(menuItem.itemId){
                R.id.toolbar_button_test->{
                    FB.crashalytics.logSingleError("Error"){
                        key("bool",true)
                        key("float", 1235)
                        key("string", "test string error")
                    }
                }
            }
            true
        }
    }
}