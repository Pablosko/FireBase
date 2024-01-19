package com.pablo_daniel.interficies.clases

import java.io.Serializable

data class ListItem(val imageResId: Int, val text: String, val targetActivity: Class<*>, val onClick: ((Int) -> Unit)? = null) : Serializable
