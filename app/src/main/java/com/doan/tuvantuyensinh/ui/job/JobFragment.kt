package com.doan.tuvantuyensinh.ui.job

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.doan.tuvantuyensinh.databinding.FragmentJobBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobFragment: Fragment() {

    private var _binding: FragmentJobBinding? = null

    private val binding get() = _binding!!

    private val viewModel: JobViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            job.observe(viewLifecycleOwner) {
                binding.jobRecyclerView.adapter = JobAdapter(it.data?.jobs ?: emptyList())
                binding.jobRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}