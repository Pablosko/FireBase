package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.Utils

import android.content.Context
import android.content.SharedPreferences
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pablo_daniel.aa3_interficies.MyApp

typealias Shared = SharedPreferencesManager

object SharedPreferencesManager {
    private const val MyPreferencesName = "MySharedPreferencesStorage"

    private val shared: SharedPreferences by lazy { MyApp.Context.getSharedPreferences(MyPreferencesName, Context.MODE_PRIVATE) }
    private val editor: SharedPreferences.Editor by lazy { shared.edit() }

    private const val UsersKey = "Users"
    public var Users: MutableList<UsersData>
        get() {
            val jsonString = shared.getString(UsersKey, "")
            val listType = object : TypeToken<MutableList<UsersData>?>() {}.type
            val usersList: MutableList<UsersData>? = Gson().fromJson(jsonString, listType)
            return usersList ?: mutableListOf()
        }
        set(value) {
            val jsonString = Gson().toJson(value)
            editor.putString(UsersKey,jsonString)
            editor.apply()
        }
}