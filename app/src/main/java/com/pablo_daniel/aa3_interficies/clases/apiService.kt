package com.pablo_daniel.aa3_interficies.clases

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pablo_daniel.aa3_interficies.R
import java.io.InputStreamReader

class ApiService(private val context: Context) : Repository {

    override suspend fun GetNewsFromJson(): MutableList<NewsData> {
        val inputStream = context.resources.openRawResource(R.raw.news_data)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<MutableList<NewsData>>() {}.type
        return Gson().fromJson(reader, type)
    }

    override suspend fun GetItemsImageList(): List<ItemImage> {
        val inputStream = context.resources.openRawResource(R.raw.items_data)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<ItemImage>>() {}.type
        return Gson().fromJson(reader, type)
    }
}
