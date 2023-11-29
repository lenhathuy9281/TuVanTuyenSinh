package com.doan.tuvantuyensinh.ui.target

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.ItemTargetBinding
import com.doan.tuvantuyensinh.domain.Target

class TargetAdapter(private val targetList: List<Target>) :
    RecyclerView.Adapter<TargetAdapter.TargetViewHolder>() {

    class TargetViewHolder(val binding: ItemTargetBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TargetViewHolder {
        val binding: ItemTargetBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_target,
            parent,
            false
        )
        return TargetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TargetViewHolder, position: Int) {
        val target = targetList[position]
        holder.binding.target = target
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return targetList.size
    }
}
