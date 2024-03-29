package com.pablo_daniel.aa3_interficies.firebase

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.pablo_daniel.aa3_interficies.dataClasses.DbUser

class MyFirebaseAuthentication(val appContext: Application) {
    private val firebaseAuthentication = FirebaseAuth.getInstance()
    private var currentUser: DbUser?= null

    fun isLoginActive() = getUser() != null
    fun getUser() = currentUser
    fun setCurrentUser(newUser: DbUser){
        currentUser = newUser
    }
    fun getAuthDbUser() : DbUser? {

        firebaseAuthentication.currentUser?.let { user ->
            val dbUser = DbUser(
                id = user.uid,
                email = user.email,
                username = user.displayName,
                photoPath = user.photoUrl.toString()
            )
            return dbUser
        }

        return null
    }
}