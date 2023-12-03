package com.doan.tuvantuyensinh.ui.news

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.doan.tuvantuyensinh.databinding.FragmentNewsDetailBinding
import com.doan.tuvantuyensinh.domain.News
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    private val viewModel: DetailNewsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("newsItem", String::class.java)
        } else {
            arguments?.getSerializable("newsItem") as String
        }
        newId?.let { viewModel.getNewsDetail(it) }

        with(viewModel) {
            news.observe(viewLifecycleOwner) {
                if (it.isSuccessful()) {
                    displayNewsItem(it.data!!)
                }
            }
        }
    }

    private fun displayNewsItem(newsItem: News) {
        binding.newsDetailTitle.text = newsItem.title
        binding.newsDetailTime.text = newsItem.time
        binding.newsDetailFullDescription.text = newsItem.fullDescription

        Glide.with(binding.root.context).load(newsItem.image).into(binding.newsDetailImage)
    }
}