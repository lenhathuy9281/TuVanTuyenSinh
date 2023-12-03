package com.doan.tuvantuyensinh.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.FragmentNewsBinding
import com.doan.tuvantuyensinh.domain.News
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            news.observe(viewLifecycleOwner) {
                if (it.isSuccessful()) {
                    val newsAdapter = it.data?.news?.let { it1 ->
                        NewsAdapter(it1) { newsItem ->
                            findNavController().navigate(R.id.action_navigation_news_to_newsDetailFragment, Bundle().apply {
                                putString("newsItem", newsItem.id)
                            })
                        }
                    }

                    with(binding) {
                        rcvNews.layoutManager = LinearLayoutManager(requireContext())
                        rcvNews.adapter = newsAdapter
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}