package com.doan.tuvantuyensinh.ui.underdevelop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doan.tuvantuyensinh.databinding.FragmentUndevelopBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UnDevelopFragment: Fragment() {

    private var _binding: FragmentUndevelopBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: UndevelopViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUndevelopBinding.inflate(inflater, container, false)

        viewModel.apply {
            onClickBack = {
                requireActivity().onBackPressed()
            }
        }

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}