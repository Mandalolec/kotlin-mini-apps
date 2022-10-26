package com.example.laba_3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.laba_3.R
import com.example.laba_3.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.nameButton.setOnClickListener{
            Toast.makeText(activity, "МОАИС-19-1", Toast.LENGTH_SHORT).show()
        }

        binding.diceButton.setOnClickListener{
            rollDice()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private fun rollDice(){
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val rollTextView: TextView = binding.textView
        rollTextView.text = diceRoll.toString()
        val diceImage: ImageView = binding.imageDice
        when(diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }

    class Dice(private val numberSides: Int){
        fun roll(): Int {
            return (1..numberSides).random()
        }
    }
}