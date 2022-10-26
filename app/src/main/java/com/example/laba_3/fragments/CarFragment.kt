package com.example.laba_3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import com.example.laba_3.databinding.FragmentCarBinding



class CarFragment : Fragment() {

    private lateinit var binding: FragmentCarBinding
    private var sum : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.calculateButton.setOnClickListener {
            sum = 0
            checkBoxParty()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CarFragment()
    }

    private fun checkBoxChecker(checkBox: CheckBox, cost: Int) : Int{
        var sum = 0
        if(checkBox.isChecked){
            sum += cost
        }
        return(sum)
    }

    private fun checkBoxParty(){
        sum += checkBoxChecker(binding.checkGuarantee,400)
        sum += checkBoxChecker(binding.chekOfRoadKit, 500)
        sum += checkBoxChecker(binding.checkSeasonalSet, 300)
        sum += checkBoxChecker(binding.checkAutomatic, 1000)
        binding.textView.text = sum.toString()
    }
}