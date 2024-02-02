package com.pablo_daniel.aa3_interficies.firebase
import android.app.Application


typealias FB = MyFirebase
class MyFirebase {
    companion object{
        lateinit var analytics: MyFirebaseAnalytics
        lateinit var authentication: MyFirebaseAuthentication
        val crashalytics = MyCrashalytics()
        val db = MyFirebaseDatabase()
        val storage = MyFirebaseStorage()
        val remoteConfig = MyFirebaseRemoteConfig()
        fun init(appContext: Application){
            authentication = MyFirebaseAuthentication(appContext)
            analytics = MyFirebaseAnalytics(appContext)

        }

    }
}