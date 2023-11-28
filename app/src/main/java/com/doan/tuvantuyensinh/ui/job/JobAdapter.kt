package com.doan.tuvantuyensinh.ui.job

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.ItemJobBinding
import com.doan.tuvantuyensinh.domain.Job

class JobAdapter(private val jobList: List<Job>) :
    RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding: ItemJobBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_job,
            parent,
            false
        )
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        holder.binding.job = job
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    class JobViewHolder(val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root)
}
