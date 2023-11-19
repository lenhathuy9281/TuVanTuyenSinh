package com.doan.tuvantuyensinh.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.FragmentHomeBinding
import com.doan.tuvantuyensinh.ui.home.function.FunctionData
import com.doan.tuvantuyensinh.ui.home.function.GridFunctionAdapter
import com.doan.tuvantuyensinh.utils.remote.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.viewModel = homeViewModel

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCarousel()
        initGridFunction()
        homeViewModel.school.observe(viewLifecycleOwner) {
            it?.let { result ->
                Log.d("resultSchool", result.toString())
                when (result.status) {
                    Resource.Status.SUCCESS -> {

                    }
                    Resource.Status.LOADING -> {
                    }
                    Resource.Status.ERROR -> {
                    }
                }
            }
        }
    }
    private fun initCarousel() {
        val imageList = listOf(
            getString(R.string.image1),
            getString(R.string.image2),
            getString(R.string.image3)
        )
        val carouselAdapter = CarouselAdapter(imageList, true)
        binding.carouselPager.adapter = carouselAdapter
    }

    private fun getListFunction(): List<FunctionData> {
        return listOf(
            FunctionData("Tư vấn học bổng", "",0),
            FunctionData("Tư vấn du học", "R.drawable.ic_study_abroad", 1),
            FunctionData("Tư vấn việc làm", "R.drawable.ic_job", 2),
            FunctionData("Tư vấn học phí", "R.drawable.ic_scholarship", 3),
            FunctionData("Tư vấn tự động", "R.drawable.ic_scholarship", 4),

        )
    }

    private fun initGridFunction() {
        val gridFunctionAdapter = GridFunctionAdapter(getListFunction()).apply {
            onClickFunction = {
                when(it.functionId) {
                    0 -> {

                    }
                    else -> {
                        findNavController().navigate(R.id.action_navigation_home_to_undevelopFragment)
                    }
                }
            }
        }
        binding.rcvFunctionsHome.adapter = gridFunctionAdapter
        binding.rcvFunctionsHome.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}