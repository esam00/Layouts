package com.example.layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.layout.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    private lateinit var binding: FragmentTwoBinding

    private val args: FragmentTwoArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false)
        bindResult()
        return binding.root
    }

    // TODO: use viewModel to display result instead of navArgs
    private fun bindResult() = with(binding) {
        resultText.text = args.result.toString()
    }
}