package com.example.laba_3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.laba_3.databinding.FragmentRubleBinding


class RubleFragment : Fragment() {

    private lateinit var binding: FragmentRubleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRubleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonDollar.setOnClickListener{
            convertCurrency(61.25)
        }

        binding.buttonEuro.setOnClickListener {
            convertCurrency(59.98)
        }

        binding.buttonGBP.setOnClickListener {
            convertCurrency(68.59)
        }

        binding.buttonYen.setOnClickListener {
            convertCurrency(0.4223)
        }

        binding.buttonLir.setOnClickListener {
            convertCurrency(3.3)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RubleFragment()
    }

    private fun convertCurrency(cost: Double) : Double{
        return if(binding.editTextRuble.length() == 0){
            0.0
        }else{
            val rub : Double = binding.editTextRuble.text.toString().toInt().toDouble() / cost
            binding.textView.text = rub.toString()
            rub
        }
    }
}