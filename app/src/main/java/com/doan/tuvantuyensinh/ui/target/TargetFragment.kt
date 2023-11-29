package com.doan.tuvantuyensinh.ui.target

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.doan.tuvantuyensinh.databinding.FragmentTargetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TargetFragment: Fragment() {

    private var _binding: FragmentTargetBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TargetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding  = FragmentTargetBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            targets.observe(viewLifecycleOwner) {
                if (it.isSuccessful()) {
                    with(binding) {
                        targetRecyclerView.apply {
                            adapter = TargetAdapter(it.data?.targets ?: emptyList())
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