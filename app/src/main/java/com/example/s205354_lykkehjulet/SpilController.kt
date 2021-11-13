package com.example.s205354_lykkehjulet

import android.content.Context
import android.content.res.Resources


class SpilController {

    val spiller = SpilData()

    fun ordController() {

        val pointFoar = spiller.spillerPoint

       // val ord = getRandomOrd()

       // var gemtOrd = gemOrd(ord)

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

    fun getRandomOrd(context: Context): String {

        val ord = context.resources.getStringArray(R.array.ord).toList()

        return ord[spiller.ranTal(ord.size-1)]
    }

    fun gemOrd (ord: String): String {

        var gemtOrd = ""

        for(i in 1..ord.length) {
            gemtOrd += "-"
        }

        return gemtOrd
    }

    fun tjekBogstav (ord: String, gemtOrd: String): String {

        return ord
    }
}