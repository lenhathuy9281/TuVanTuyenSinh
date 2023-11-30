package com.doan.tuvantuyensinh.ui.major

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.ItemMajorBinding
import com.doan.tuvantuyensinh.domain.Major

class MajorAdapter(private val majorList: List<Major>) :
    RecyclerView.Adapter<MajorAdapter.MajorViewHolder>() {

    class MajorViewHolder(val binding: ItemMajorBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MajorViewHolder {
        val binding: ItemMajorBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_major,
            parent,
            false
        )
        return MajorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MajorViewHolder, position: Int) {
        val major = majorList[position]
        holder.binding.major = major
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return majorList.size
    }
}