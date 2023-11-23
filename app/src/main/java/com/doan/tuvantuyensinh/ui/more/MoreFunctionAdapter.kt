package com.doan.tuvantuyensinh.ui.more

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.databinding.ItemFunctionMoreBinding
import com.doan.tuvantuyensinh.ui.home.function.FunctionData


class MoreFunctionAdapter(recyclerDataArrayList: List<FunctionData>) :
    RecyclerView.Adapter<MoreFunctionAdapter.RecyclerViewHolder>() {
    private val courseDataArrayList: ArrayList<FunctionData>

    var onClickFunction: ((FunctionData) -> Unit)? = null

    init {
        courseDataArrayList = ArrayList(recyclerDataArrayList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val binding = ItemFunctionMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        // Set the data to textview and imageview.
        val recyclerData: FunctionData = courseDataArrayList[position]
        holder.bind(recyclerData)
    }

    override fun getItemCount(): Int {
        // this method returns the size of recyclerview
        return courseDataArrayList.size
    }

    // View Holder Class to handle Recycler View.
    inner class RecyclerViewHolder(private val binding: ItemFunctionMoreBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {
                root.setOnClickListener {
                    if (bindingAdapterPosition > -1) {
                        onClickFunction?.invoke(courseDataArrayList[bindingAdapterPosition])
                    }

                }
            }
        }

        fun bind(item: FunctionData) {
            with(binding) {
                tvFunctionName.text = item.title
            }
        }
    }
}
