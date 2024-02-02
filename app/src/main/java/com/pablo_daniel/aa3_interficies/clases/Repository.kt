package com.pablo_daniel.aa3_interficies.clases

interface Repository {
    suspend fun GetNewsFromJson(): MutableList<NewsData>
    suspend fun GetItemsImageList(): List<ItemImage>
}