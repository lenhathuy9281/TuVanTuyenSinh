package com.doan.tuvantuyensinh.ui.scholarship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doan.tuvantuyensinh.databinding.FragmentScholarshipBinding
import com.doan.tuvantuyensinh.ui.scholarship.ScholarshipViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScholarshipFragment: Fragment() {

    private var _binding: FragmentScholarshipBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ScholarshipViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScholarshipBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            scholarship.observe(viewLifecycleOwner) {
//                binding.scholarshipRecyclerView.adapter = ScholarshipAdapter(it.data?.scholarships ?: emptyList())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}