package com.doan.tuvantuyensinh.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.ui.more.MoreFunctionViewModel
import com.doan.tuvantuyensinh.databinding.FragmentMoreFunctionBinding
import com.doan.tuvantuyensinh.ui.home.function.FunctionData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFunctionFragment : Fragment() {

    private var _binding: FragmentMoreFunctionBinding? = null
    private val binding get() = _binding!!

    private val moreFunctionViewModel: MoreFunctionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreFunctionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.viewModel = moreFunctionViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            userFunctionRecyclerView.apply {
                val listFunctionData = listOf(
                    FunctionData("Xem thông tin trường", "ic_truong_hoc",0),
                    FunctionData("Thông tin nghề nghiệp liên quan", "ic_job", 1),
                    FunctionData("Thông tin học phí", "ic_hoc_phi", 2),
                    FunctionData("Thông tin học bổng", "ic_hoc_bong", 3),
                    FunctionData("Thông tin chỉ tiêu", "ic_chi_tieu", 4),
                )
                adapter = MoreFunctionAdapter(listFunctionData).apply {
                    onClickFunction = {

                    }
                }

                layoutManager = LinearLayoutManager(requireContext())
            }

            val listFunctionDataAdmin = listOf(
                FunctionData("Quản lý trường", "ic_school", 10),
                FunctionData("Quản lý nghề", "ic_job", 11),
                FunctionData("Quản lý học phí", "ic_fee", 12),
                FunctionData("Quản lý học bổng", "ic_scholarship", 13),
                FunctionData("Quản lý chỉ tiêu", "ic_target", 14),
                FunctionData("Quản lý ngành", "ic_major", 15),
            )
            adminFunctionRecyclerView.apply {
                adapter = MoreFunctionAdapter(listFunctionDataAdmin).apply {
                    onClickFunction = {
                        when(it.functionId) {
                            10 -> {
                                findNavController().navigate(R.id.action_more_function_fragment_to_navigation_school_info)
                            }
                            11 -> {
                                findNavController().navigate(R.id.action_more_function_fragment_to_navigation_job)
                            }
                            12-> {
                                findNavController().navigate(R.id.action_more_function_fragment_to_navigation_tuition)
                            }
                            13 -> {
                                findNavController().navigate(R.id.action_more_function_fragment_to_navigation_scholarship)
                            }
                            14 -> {
                                findNavController().navigate(R.id.action_more_function_fragment_to_navigation_target)
                            }
                            else -> {
                                findNavController().navigate(R.id.action_more_function_fragment_to_undevelopFragment)
                            }
                        }
                    }
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
}