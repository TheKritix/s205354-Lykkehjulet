package com.example.s205354_lykkehjulet

import android.content.Context
import android.content.res.Resources
import java.util.*
import kotlin.collections.HashMap

class SpilController {

    val spiller = SpilData()

    fun ordController() {

        val pointFoar = spiller.getSpillerPoint()

        val ord = getRandomOrd()

        var gemtOrd = gemOrd(ord)

    }

    fun drejHjullet(): Int {
        spiller.lykkehjul(spiller.ranTal(24))

        return spiller.getSpillerPoint()
    }

    fun getRandomOrd(): String {

        //TODO: Der skal lige spørges om det her overhovedet er ok at bruge.
        val ord: List<String> = Resources.getSystem().getStringArray(R.array.ord).toList()

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