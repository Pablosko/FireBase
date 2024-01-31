package com.pablo_daniel.aa3_interficies.firebase

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.pablo_daniel.aa3_interficies.R

class MyFirebaseRemoteConfig {
    private val remoteConfig = Firebase.remoteConfig
    enum class RemoteKeys(val key:String){
        CurrentTheme("current_theme")
    }
    init{
        val configSettings = remoteConfigSettings{
            minimumFetchIntervalInSeconds = 30 //low value for test, set greater value on production
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(R.xml.remote_config_degaults)

        remoteConfig.fetchAndActivate()
    }

    enum class AppTheme(val key:String, val themeId:Int){
        Base("Base", R.style.Theme_AA3_Interficies);


        companion object{
            fun fromKey(key:String):AppTheme{
                return values().find{ theme-> theme.key == key} ?: Base
            }
        }
    }

    fun getTheme(): AppTheme{
        val key = remoteConfig.getString(RemoteKeys.CurrentTheme.key)
        return AppTheme.fromKey(key)
    }
}