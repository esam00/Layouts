package com.example.layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.layout.databinding.FragmentOneBinding

class FragmentOne : Fragment() {
    private lateinit var binding: FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)
        setupCounter()
        setupResultButton()
        return binding.root
    }

    private var counter = 0
    private fun setupCounter() = with(binding) {
        addButton.setOnClickListener {
            ++counter
            counterText.text = counter.toString()
        }
    }

    private fun setupResultButton() = with(binding) {
        showResultButton.setOnClickListener {
            findNavController().navigate(
                FragmentOneDirections.actionFragmentOneToFragmentTwo2(
                    counter
                )
            )
        }
    }
}