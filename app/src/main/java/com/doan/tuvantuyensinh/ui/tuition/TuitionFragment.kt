package com.doan.tuvantuyensinh.ui.tuition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.doan.tuvantuyensinh.databinding.FragmentTuitionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TuitionFragment : Fragment() {
    private var _binding: FragmentTuitionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TuitionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTuitionBinding.inflate(layoutInflater, container, false)


        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            tuition.observe(viewLifecycleOwner) {
                it?.let {
                   if (it.isSuccessful()) {
                       with(binding) {
                           tuitionRecyclerView.apply {
                               adapter = TuitionAdapter(it.data?.tuition ?: emptyList())
                               layoutManager = LinearLayoutManager(requireContext())
                           }
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