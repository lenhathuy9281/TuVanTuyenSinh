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


        with(binding) {
            fabChatBot.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_navigation_chat)
            }
        }
    }
    private fun initCarousel() {

        val imageList = listOf(
            getString(R.string.image1),
            getString(R.string.image2),
            getString(R.string.image3),
            getString(R.string.image_banner)
        )
        val carouselAdapter = CarouselAdapter(imageList, true)
        binding.carouselPager.adapter = carouselAdapter
    }

    private fun getListFunction(): List<FunctionData> {
        return listOf(
            FunctionData("Xem thông tin trường", "ic_truong_hoc",0),
            FunctionData("Cơ hội việc làm", "ic_job", 1),
            FunctionData("Thông tin học phí", "ic_hoc_phi", 2),
            FunctionData("Thông tin học bổng", "ic_hoc_bong", 3),
            FunctionData("Thông tin chỉ tiêu", "ic_chi_tieu", 4),
            FunctionData("Danh sách chức năng", "ic_list_function", 5),

        )
    }

    private fun initGridFunction() {
        val gridFunctionAdapter = GridFunctionAdapter(getListFunction()).apply {
            onClickFunction = {
                when(it.functionId) {
                    getListFunction().size -1 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_more_function_fragment)
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