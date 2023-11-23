package com.doan.tuvantuyensinh.ui.underdevelop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UndevelopViewModel @Inject constructor(): ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Chức năng này đang trong quá trình phát triển"
    }
    val text: LiveData<String> = _text
    var onClickBack: () -> Unit = {}

    fun back() {
           onClickBack.invoke()
    }
}