package com.doan.tuvantuyensinh.ui.school

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.doan.tuvantuyensinh.databinding.FragmentSchoolInfoBinding
import com.doan.tuvantuyensinh.utils.remote.Resource
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            viewModel.school.observe(viewLifecycleOwner) {
                it?.let { result ->
                    when (result.status) {
                        Resource.Status.SUCCESS -> {
                            with(binding) {
                                val school = result.data
                                school?.let { it ->
                                    tvSchoolName.text = it.name
                                    tvSchoolAddress.text = "${it.duong} ${it.quan} ${it.thanhPho}"
                                    Glide.with(requireContext()).load(it.image).into(imvSchool)
                                    tvSchoolDescription.text = it.description
                                }

                            }
                        }
                        Resource.Status.LOADING -> {
                        }
                        Resource.Status.ERROR -> {
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