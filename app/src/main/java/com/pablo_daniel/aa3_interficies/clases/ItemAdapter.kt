package com.pablo_daniel.aa3_interficies.clases

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pablo_daniel.aa3_interficies.R

class ImageAdapter(private val context: Context) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var itemsImageList: List<String> = emptyList()

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = itemsImageList[position]
        val imageResourceId = getImageResourceId(currentItem)
        holder.imageView.setImageResource(imageResourceId)
    }

    override fun getItemCount(): Int {
        return itemsImageList.size
    }

    fun setItemsImageList(items: List<String>) {
        itemsImageList = items
        notifyDataSetChanged()
    }

    private fun getImageResourceId(imageFileName: String): Int {
        // Obtén el ID de recursos de la imagen según su nombre de archivo (sin extensión)
        val resourceId = context.resources.getIdentifier(
            imageFileName.replace(".png", ""),
            "drawable",
            context.packageName
        )
        return if (resourceId != 0) resourceId else R.drawable.tft_item_bfsword // Si no se encuentra, utiliza una imagen predeterminada
    }
}
