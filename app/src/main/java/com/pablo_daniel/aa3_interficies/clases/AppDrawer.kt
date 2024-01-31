package com.pablo_daniel.aa3_interficies.clases

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pablo_daniel.aa3_interficies.R
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener
import com.google.android.material.navigation.NavigationView
import com.pablo_daniel.aa3_interficies.activities.MainActivity
import com.pablo_daniel.aa3_interficies.fragments.screens.Screen_Contact
import com.pablo_daniel.aa3_interficies.fragments.screens.Screen_Login

class AppDrawer: Fragment(), DrawerListener{

    companion object {
        private lateinit var Instance: AppDrawer
        fun get() = Instance
    }

    lateinit var fragmentView: View
    private val drawer by lazy { fragmentView.findViewById<DrawerLayout>(R.id.AppDrawer) }
    private val navigationDrawer by lazy { fragmentView.findViewById<NavigationView>(R.id.navigationDrawer) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.component_navigation_drawer, container, false)

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drawer.addDrawerListener(this)
        navigationDrawer.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId)
            {
                R.id.login_drawer_button -> {
                    openLogin()
                    drawer.close()
                }

            }
            when(menuItem.itemId)
            {
                R.id.return_drawer_button -> {
                    returnToHome()
                    drawer.close()
                }
            }
            when(menuItem.itemId)
            {
                R.id.contact_drawer_button -> {
                    openContactUs()
                    drawer.close()

                }
            }
            true
        }
    }
    fun openLogin(){
        val loginScreen = Screen_Login()
        val transaction = childFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.enter_from_right, R.anim.exit_to_right,
            R.anim.enter_from_right, R.anim.exit_to_right
        )
        transaction.replace(R.id.reusableDialogsContainer, loginScreen)
            .addToBackStack(null)
            .commit()

    }
    fun openContactUs(){
        val contactScreen = Screen_Contact()
        val transaction = childFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.enter_from_right, R.anim.exit_to_right,
            R.anim.enter_from_right, R.anim.exit_to_right
        )
        transaction.replace(R.id.reusableDialogsContainer, contactScreen)
            .addToBackStack(null)
            .commit()


    }
    private fun returnToHome(){
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)

    }

    fun openDrawer()
    {
        drawer.open()
    }

    fun checkLoginState(){
       // val isLoginActive = FB.authentication.isLoginActive()
       // navigationDrawer.menu.findItem(R.id.login_drawer_button).isVisible=! isLoginActive

        //navigationDrawer.menu.findItem(R.id.profile_drawer_button).isVisible= isLoginActive
    }
    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        checkLoginState()
    }

    override fun onDrawerOpened(drawerView: View) {
        checkLoginState()
    }

    override fun onDrawerClosed(drawerView: View) {
        // Nothing
    }

    override fun onDrawerStateChanged(newState: Int) {
        // Nothing
    }
}