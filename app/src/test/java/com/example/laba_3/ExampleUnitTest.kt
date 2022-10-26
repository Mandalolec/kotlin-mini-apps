package com.example.laba_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.laba_3.databinding.FragmentCarBinding
import com.example.laba_3.fragments.CarFragment
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

}

class CarFragmentTest : Fragment() {

    private lateinit var binding: FragmentCarBinding
    private val checkGuarantee: CheckBox = binding.checkGuarantee
    private val chekOfRoadKit: CheckBox = binding.chekOfRoadKit
    private val checkSeasonalSet: CheckBox = binding.checkSeasonalSet
    private val checkAutomatic: CheckBox = binding.checkAutomatic
    private val calculate: Button = binding.calculateButton
    private var sum: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarBinding.inflate(inflater)
        return binding.root
    }
@Test
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            checkBoxParty()
            sum = 0
    }

    companion object {
        @JvmStatic
        fun newInstance() = CarFragment()
    }

    private fun checkBoxChecker(checkBox: CheckBox, cost: Int): Int {
        var sum = 0
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            sum += if (isChecked) {
                cost
            } else {
                0
            }
        }
        return (sum)
    }
    private fun checkBoxParty() {
        sum += checkBoxChecker(checkGuarantee, 400)
        sum += checkBoxChecker(chekOfRoadKit, 500)
        sum += checkBoxChecker(checkSeasonalSet, 300)
        sum += checkBoxChecker(checkAutomatic, 1000)
        binding.textView.text = sum.toString()
    }
}