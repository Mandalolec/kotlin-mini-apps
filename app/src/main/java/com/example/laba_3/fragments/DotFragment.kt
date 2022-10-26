package com.example.laba_3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.laba_3.R
import com.example.laba_3.databinding.FragmentDotBinding
import com.bumptech.glide.Glide

class DotFragment : Fragment() {

    private lateinit var binding: FragmentDotBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDotBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonWhat.setOnClickListener {
            Glide.with(this).load(R.drawable.what).into(binding.gifView)
        }

        binding.buttonParabola.setOnClickListener {
            Glide.with(this).load(R.drawable.parabola).into(binding.gifView)
        }

        binding.buttonFreeFall.setOnClickListener {
            Glide.with(this).load(R.drawable.free_fall).into(binding.gifView)
        }

        binding.buttonHorizontalThrow.setOnClickListener {
            Glide.with(this).load(R.drawable.horizontal).into(binding.gifView)
        }

        binding.buttonCircularMotion.setOnClickListener {
            Glide.with(this).load(R.drawable.circular).into(binding.gifView)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DotFragment()
    }
}