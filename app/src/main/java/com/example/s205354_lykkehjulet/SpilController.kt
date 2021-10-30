package com.example.s205354_lykkehjulet

import android.content.Context
import android.content.res.Resources
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap

class SpilController {

    val spiller = SpilData()

    fun ordController() {

        val pointFoar = spiller.spillerPoint

        val ord = getRandomOrd()

        var gemtOrd = gemOrd(ord)

    }

    fun getSpillerLiv(): Int {
        return spiller.spillerLiv
    }

    fun getSpillerPoint(): Int {
        return spiller.spillerPoint
    }

    fun drejHjullet(): String {

        return spiller.lykkehjul(spiller.ranTal(24))
    }

    fun getRandomOrd(): String {



        //try {
            var ord: List<String> = Resources.getSystem().getStringArray(R.array.ord).toList()
        //}

        //catch (e: IllegalArgumentException) {
            //e.printStackTrace()
        //}

        return ord[spiller.ranTal(ord.size)]
    }

    fun gemOrd (ord: String): String {

        var gemtOrd = ""

        for(i in 1..ord.length) {
            gemtOrd += "-"
        }

        return gemtOrd
    }
}