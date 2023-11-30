package com.doan.tuvantuyensinh.ui.major

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.doan.tuvantuyensinh.databinding.FragmentMajorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MajorFragment : Fragment() {

    private var _binding: FragmentMajorBinding? = null

    private val binding get() = _binding!!
    private val viewModel: MajorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMajorBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            majors.observe(viewLifecycleOwner) {
                with(binding) {
                    if (it.isSuccessful()) {
                        majorRecyclerView.apply {
                            adapter = MajorAdapter(it.data?.majors ?: emptyList())
                            layoutManager = LinearLayoutManager(requireContext())
                        }
                    }
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}