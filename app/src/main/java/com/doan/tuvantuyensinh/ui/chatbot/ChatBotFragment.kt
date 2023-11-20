package com.doan.tuvantuyensinh.ui.chatbot

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doan.tuvantuyensinh.databinding.FragmentChatbotBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class ChatBotFragment: Fragment() {
    private var _binding: FragmentChatbotBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: ChatBotViewModel by viewModels()
    private lateinit var mediaRecorder: MediaRecorder
    private var isRecording = false
    private var fileName: String? = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChatbotBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            iconMic.setOnClickListener {
                if (!isRecording) {
                    startRecording()
                    Handler(Looper.getMainLooper()).postDelayed({
                        stopRecording()
                        viewModel.uploadMp3(fileName!!)
                    }, 5000) // Stop recording after 5 seconds
                }
            }
        }
    }

    private fun startRecording() {
        val externalCacheDir = ContextCompat.getExternalFilesDirs(requireContext(), null)[0]
        fileName = "${externalCacheDir.absolutePath}/audiorecordtest.mp3"
        if (checkPermissions()) {
            mediaRecorder = MediaRecorder()
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            mediaRecorder.setOutputFile(fileName)
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                mediaRecorder.prepare()
                mediaRecorder.start()
                isRecording = true
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun stopRecording() {
        if (isRecording) {
            mediaRecorder.stop()
            mediaRecorder.release()
            isRecording = false
        }
    }

    private fun checkPermissions(): Boolean {
        val permission = Manifest.permission.RECORD_AUDIO
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(permission),
                1
            )
            return false
        }
        return true
    }

    override fun onStop() {
        super.onStop()
        stopRecording()
    }
}