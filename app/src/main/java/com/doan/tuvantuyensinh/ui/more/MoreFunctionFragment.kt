package com.doan.tuvantuyensinh.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
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
                    FunctionData("Thông tin cá nhân", "ic_user"),
                    FunctionData("Đổi mật khẩu", "ic_password"),
                    FunctionData("Đăng xuất", "ic_logout")
                )
                adapter = MoreFunctionAdapter(listFunctionData).apply {
                    onClickFunction = {

                    }
                }

                layoutManager = LinearLayoutManager(requireContext())
            }

            val listFunctionDataAdmin = listOf(
                FunctionData("Quản lý ngành", "ic_major"),
                FunctionData("Quản lý trường", "ic_school"),
                FunctionData("Quản lý người dùng", "ic_user"),
                FunctionData("Quản lý tin tức", "ic_news"),
                FunctionData("Quản lý hướng dẫn", "ic_guide"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
                FunctionData("Quản lý đơn xét tuyển", "ic_apply"),
            )
            adminFunctionRecyclerView.apply {
                adapter = MoreFunctionAdapter(listFunctionDataAdmin).apply {
                    onClickFunction = {

                    }
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
}