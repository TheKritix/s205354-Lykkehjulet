package com.example.s205354_lykkehjulet

import android.content.Context
import java.lang.Exception
import java.lang.StringBuilder


/**
 * @Source https://www.w3schools.com/java/ref_string_indexof.asp
 */

class SpilController {

    val spiller = SpilData()

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

    fun tjekBogstav (ord: String, gemtOrd: String, bogstav: Char): String {

        var gemtOrdTemp = gemtOrd
        var position: Int
        var pointKontrol = true

        for (i in 0..gemtOrd.length) {

            position = ord.indexOf(bogstav.lowercaseChar(), i)

            if (position != -1) {
                val gOrd = StringBuilder(gemtOrdTemp)
                gOrd.setCharAt(position, bogstav.lowercaseChar())
                gemtOrdTemp = gOrd.toString()

                if (pointKontrol) {
                    tjekBogstavRigtig()
                    pointKontrol = false
                }
            }

        }

        if (gemtOrdTemp == gemtOrd) {
            spiller.skiftSpillerLiv(-1)
        }

        return gemtOrdTemp
    }

    fun tjekBogstavRigtig() {

        spiller.increaseSpillerPoint()

    }

    fun tjekVinder (ord: String, gemtOrd: String): Boolean {
        if (ord == gemtOrd) {return true}

        return false
    }

    fun tjekTaber(): Boolean {

        if(getSpillerLiv() == 0) {return true}

        return false
    }
}