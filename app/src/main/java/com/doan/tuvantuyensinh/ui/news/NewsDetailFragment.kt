package com.doan.tuvantuyensinh.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.doan.tuvantuyensinh.databinding.FragmentNewsDetailBinding
import com.doan.tuvantuyensinh.domain.ItemNews
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val newsItem = arguments?.getSerializable("newsItem") as ItemNews
//        displayNewsItem(newsItem)
    }

    private fun displayNewsItem(newsItem: ItemNews) {
        binding.newsDetailTitle.text = newsItem.title
        binding.newsDetailTime.text = newsItem.time
        binding.newsDetailFullDescription.text = newsItem.fullDescription
    }
}