package com.doan.tuvantuyensinh.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.databinding.ItemNewsHomeBinding
import com.doan.tuvantuyensinh.domain.ItemNews

class NewsAdapter(private val newsList: List<ItemNews>, private val itemClickListener: (ItemNews) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemNewsHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: ItemNews) {
            binding.newsTitle.text = newsItem.title
            binding.newsTime.text = newsItem.time
            binding.newsShortDescription.text = newsItem.shortDescription

            itemView.setOnClickListener { itemClickListener(newsItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.bind(newsItem)
    }
}