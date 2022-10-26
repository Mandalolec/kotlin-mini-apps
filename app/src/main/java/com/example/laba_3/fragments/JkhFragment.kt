package com.example.laba_3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.laba_3.databinding.FragmentJkhBinding

class JkhFragment : Fragment() {

    private lateinit var binding: FragmentJkhBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJkhBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonCalculate.setOnClickListener {
            binding.textView.text = (calculateJKH(binding.currentHuman) * (calculateJKH(binding.apartmentArea) + calculateJKH(binding.metersData))).toString()
        }
    }

    private fun calculateJKH(editText: EditText) : Int{
        return if(editText.length() == 0){
            0
        }else{
            editText.text.toString().toInt()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = JkhFragment()
    }
}