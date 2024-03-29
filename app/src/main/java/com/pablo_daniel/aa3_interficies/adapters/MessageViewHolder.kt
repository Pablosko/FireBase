package com.pablo_daniel.aa3_interficies.adapters

import android.graphics.BitmapFactory
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.pablo_daniel.aa3_interficies.R
import com.pablo_daniel.aa3_interficies.dataClasses.DbMessage
import com.pablo_daniel.aa3_interficies.firebase.FB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MessageViewHolder(view: View): RecyclerView.ViewHolder(view){
    val container by lazy { view.findViewById<LinearLayout>(R.id.message_container) }
    val message by lazy { view.findViewById<MaterialTextView>(R.id.message_text) }
    val image by lazy { view.findViewById<ImageView>(R.id.message_image) }

    fun setUpWithMessage(dbMessage: DbMessage){
        if(dbMessage.userId == FB.authentication.getUser()?.id){
            container.gravity= Gravity.RIGHT
        }else{
            container.gravity= Gravity.LEFT
        }

        dbMessage.message?.let {text->
            message.text=text
            message.visibility= View.VISIBLE
        }?:kotlin.run {
            message.visibility= View.GONE
        }
        dbMessage.image?.let { imageUrl ->
            CoroutineScope(Dispatchers.IO).launch {
                val stream = URL(imageUrl).openStream()
                val bitMap = BitmapFactory.decodeStream(stream)
                CoroutineScope(Dispatchers.Main).launch {
                    image.setImageBitmap(bitMap)
                    image.visibility = View.VISIBLE
                }
            }
        }?:kotlin.run {
            image.visibility = View.GONE
        }
    }
}