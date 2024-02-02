package com.pablo_daniel.aa3_interficies.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pablo_daniel.aa3_interficies.R
import com.pablo_daniel.aa3_interficies.clases.ApiService
import com.pablo_daniel.aa3_interficies.clases.ImageAdapter
import kotlinx.coroutines.launch

class Screen_Items : Fragment() {

    private lateinit var fragmentView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemsAdapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.item_screen, container, false)
        recyclerView = fragmentView.findViewById(R.id.itemsRecyclerView)
        itemsAdapter = ImageAdapter(requireContext())

        // Use lifecycleScope to launch a coroutine
        lifecycleScope.launch {
            val apiService = ApiService(context = requireContext())
            val itemsImageList = apiService.GetItemsImageList().map { it.image }

            // Set the items image list to the adapter
            itemsAdapter.setItemsImageList(itemsImageList)

            // Set up RecyclerView with GridLayoutManager
            recyclerView.layoutManager = GridLayoutManager(context, 3) // Adjust the span count as needed
            recyclerView.adapter = itemsAdapter
        }
        return fragmentView
    }
}
