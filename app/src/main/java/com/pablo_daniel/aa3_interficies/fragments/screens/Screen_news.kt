package com.pablo_daniel.aa3_interficies.fragments.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pablo_daniel.aa3_interficies.R
import com.pablo_daniel.aa3_interficies.clases.ApiService
import com.pablo_daniel.aa3_interficies.clases.NewsAdapter
import kotlinx.coroutines.launch

class ScreenNews : Fragment() {

    private lateinit var fragmentView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter // Create an adapter for your RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentView = inflater.inflate(R.layout.screen_news, container, false)

        recyclerView = fragmentView.findViewById(R.id.recyclerView)
        newsAdapter = NewsAdapter()

        // Use lifecycleScope to launch a coroutine
        lifecycleScope.launch {
            val apiService = ApiService(context = requireContext())
            val newsDataList = apiService.GetNewsFromJson()

            // Set the news data to the adapter
            newsAdapter.setNewsDataList(newsDataList)
            Log.d("ScreenNews", "News data size: ${newsDataList.size}")
            // Set up RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = newsAdapter
        }

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
