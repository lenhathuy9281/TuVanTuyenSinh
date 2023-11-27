package com.doan.tuvantuyensinh.ui.home.function

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.ItemFunctionHomeBinding
import com.doan.tuvantuyensinh.utils.getDrawableFromString


class GridFunctionAdapter(recyclerDataArrayList: List<FunctionData>) :
    RecyclerView.Adapter<GridFunctionAdapter.RecyclerViewHolder>() {
    private val courseDataArrayList: ArrayList<FunctionData>

    var onClickFunction: ((FunctionData) -> Unit)? = null

    init {
        courseDataArrayList = ArrayList(recyclerDataArrayList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val binding = ItemFunctionHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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
    inner class RecyclerViewHolder(private val binding: ItemFunctionHomeBinding) : RecyclerView.ViewHolder(binding.root) {

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
                val drawable = root.context.getDrawableFromString(item.image)
                if (drawable != null) {
                    imvFunctionIcon.setImageDrawable(drawable)
                } else {
                    imvFunctionIcon.setImageResource(R.drawable.ic_truong_hoc)
                }
//                imvFunctionIcon.setImageDrawable(root.context.getDrawableFromString(item.image))
            }
        }
    }
}
