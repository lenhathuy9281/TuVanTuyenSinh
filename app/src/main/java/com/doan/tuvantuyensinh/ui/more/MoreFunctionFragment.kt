package com.doan.tuvantuyensinh.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doan.tuvantuyensinh.ui.more.MoreFunctionViewModel
import com.doan.tuvantuyensinh.databinding.FragmentMoreFunctionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFunctionFragment : Fragment() {

    private var _binding: FragmentMoreFunctionBinding? = null
    private val binding get() = _binding!!

    private val moreFunctionViewModel: MoreFunctionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreFunctionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.viewModel = moreFunctionViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return root
    }
}