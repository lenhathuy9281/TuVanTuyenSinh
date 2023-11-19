package com.doan.tuvantuyensinh.ui.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doan.tuvantuyensinh.databinding.FragmentSchoolInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolInfoFragment: Fragment() {
    private var _binding: FragmentSchoolInfoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSchoolInfoBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}