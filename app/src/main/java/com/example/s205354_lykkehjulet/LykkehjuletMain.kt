package com.example.s205354_lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBar(navController)
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController)
    }


        /**setContentView(binding.root)

        binding.FragmentBTN1.setOnClickListener {

            skiftFragment(Fragment1())
        }

        binding.FragmentBTN2.setOnClickListener {

            skiftFragment(Fragment2())

        }
    }

    private fun skiftFragment(fragment: Fragment) {

        val fragmentHaandtering = supportFragmentManager
        val fragmentTransaction = fragmentHaandtering.beginTransaction()

        //Bytter rundt på vores fragment og fragmentcontainer (Containeren ligger i activity_main.xml)
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }**/


}