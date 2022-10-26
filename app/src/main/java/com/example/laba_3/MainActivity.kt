package com.example.laba_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.laba_3.databinding.ActivityMainBinding
import com.example.laba_3.fragments.CarFragment
import com.example.laba_3.fragments.DotFragment
import com.example.laba_3.fragments.JkhFragment
import com.example.laba_3.fragments.RubleFragment
import com.example.laba_3.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private val carFragment = CarFragment()
    private val dotFragment = DotFragment()
    private val jkhFragment = JkhFragment()
    private val rubleFragment = RubleFragment()
    private val homeFragment = HomeFragment()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeFragment)

        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.ic_car -> replaceFragment(carFragment)
                R.id.ic_ruble_sign -> replaceFragment(rubleFragment)
                R.id.ic_jkh -> replaceFragment(jkhFragment)
                R.id.ic_dot -> replaceFragment(dotFragment)
                R.id.ic_home -> replaceFragment(homeFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_wrapper, fragment)
        fragmentTransaction.commit()
    }
}