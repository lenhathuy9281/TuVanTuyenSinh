package com.doan.tuvantuyensinh.ui.tuition

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.ItemTuitionBinding
import com.doan.tuvantuyensinh.domain.Tuition


class TuitionAdapter(private val tuitionList: List<Tuition>) :
    RecyclerView.Adapter<TuitionAdapter.TuitionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TuitionViewHolder {
        val binding: ItemTuitionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_tuition,
            parent,
            false
        )
        return TuitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TuitionViewHolder, position: Int) {
        val tuition = tuitionList[position]
        holder.binding.tuition = tuition
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return tuitionList.size
    }

    class TuitionViewHolder(val binding: ItemTuitionBinding) : RecyclerView.ViewHolder(binding.root)
}
