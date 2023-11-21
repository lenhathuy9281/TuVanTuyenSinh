package com.doan.tuvantuyensinh.ui.chatbot

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.FragmentChatbotBinding
import com.doan.tuvantuyensinh.utils.remote.Resource
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

        with(viewModel) {
            sendMp3.observe(viewLifecycleOwner) {
                it?.let { result ->
                    Log.d("resultChatBot", result.toString())
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

        with(binding) {
            iconMic.setOnClickListener {
                if (!isRecording) {
                    startRecording()
                    iconMic.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_mic_off))
//                    Handler(Looper.getMainLooper()).postDelayed({
//
//                    }, 5000) // Stop recording after 5 seconds
                } else {
                    stopRecording()
                    iconMic.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_mic))
                    viewModel.uploadMp3(fileName!!)
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
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            mediaRecorder.setOutputFile(fileName)

            try {
                mediaRecorder.prepare()
                mediaRecorder.start()
                isRecording = true
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(
                    Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), 1
            )
        }
    }

    private fun stopRecording() {
        mediaRecorder.stop()
        mediaRecorder.reset();
        mediaRecorder.release()
        isRecording = false
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