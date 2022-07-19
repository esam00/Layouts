package com.example.layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.layout.databinding.FragmentOneBinding

class FragmentOne : Fragment() {
    private lateinit var binding: FragmentOneBinding
    private lateinit var videModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)
        initViewModel()
        setupCounter()
        setupResultButton()
        return binding.root
    }

    private fun initViewModel() {
        videModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun setupCounter() = with(binding) {
        videModel.counter.observe(viewLifecycleOwner) {
            counterText.text = it.toString()
        }

        addButton.setOnClickListener {
            videModel.add()
        }
    }

    private fun setupResultButton() = with(binding) {
        showResultButton.setOnClickListener {
        }
    }
}