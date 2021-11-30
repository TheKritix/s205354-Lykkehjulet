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
 * Ved første start husk at rebuild project, så directions bliver oprettet.
 *
 * Kilder:
 *
 * ** Kilder til Fragments:
 * @Source https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component#10
 * @Source https://youtu.be/Q2HY58s9cHs
 * ** Kilde til top bar håndtering:
 * @Source https://stackoverflow.com/questions/36236181/how-to-remove-title-bar-from-the-android-activity
 * @Source https://developer.android.com/guide/navigation/navigation-ui
 */

class LykkehjuletMain : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Opretter binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //opretter vores navController parameter.
        //specifik kilde: https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component#7
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBar(navController)

        //Fjener top bar - https://stackoverflow.com/questions/36236181/how-to-remove-title-bar-from-the-android-activity
        supportActionBar?.hide()
    }

    //Sætter top baren til at afspejle hvilket fragment den er på. Som udgangspunkt er topbaren fjernet.
    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    //Gør så man kan trykke tilbage på topbaren, hvis man ønsker den implementeret i en given fragment
    //Kilde: https://developer.android.com/guide/navigation/navigation-ui
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}