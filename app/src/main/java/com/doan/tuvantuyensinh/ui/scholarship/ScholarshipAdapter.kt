package com.doan.tuvantuyensinh.ui.scholarship

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.ItemScholarshipBinding
import com.doan.tuvantuyensinh.domain.Scholarship

class ScholarshipAdapter(private val scholarshipList: List<Scholarship>) :
    RecyclerView.Adapter<ScholarshipAdapter.ScholarshipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScholarshipViewHolder {
        val binding: ItemScholarshipBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_scholarship,
            parent,
            false
        )
        return ScholarshipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScholarshipViewHolder, position: Int) {
        val scholarship = scholarshipList[position]
        holder.binding.scholarship = scholarship
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return scholarshipList.size
    }

    class ScholarshipViewHolder(val binding: ItemScholarshipBinding) : RecyclerView.ViewHolder(binding.root)
}
