package com.example.s205354_lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.fragment.app.Fragment
import com.example.s205354_lykkehjulet.databinding.ActivityMainBinding


/**
 *
 * Dette projekt er kodet af Kristoffer T. Pedersen (s205354)
 * @author Kristoffer T. Pedersen s205354
 *
 * Kilder:
 *
 * ** Kilder til Fragments:
 *      https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component#10
 *      https://youtu.be/Q2HY58s9cHs
 */

class LykkehjuletMain : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.FragmentBTN1.setOnClickListener{

            skiftFragment(Fragment1())
        }

        binding.FragmentBTN2.setOnClickListener{

            skiftFragment(Fragment2())

        }
    }

    private fun skiftFragment(fragment : Fragment) {

        val fragmentHaandtering = supportFragmentManager
        val fragmentTransaction = fragmentHaandtering.beginTransaction()

        //Bytter rundt på vores fragment og fragmentcontainer (Containeren ligger i activity_main.xml)
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }


}