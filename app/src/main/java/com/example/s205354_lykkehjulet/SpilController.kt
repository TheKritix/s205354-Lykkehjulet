package com.example.s205354_lykkehjulet

import android.content.Context
import java.lang.Exception
import java.lang.StringBuilder


/**
 * @Source https://www.w3schools.com/java/ref_string_indexof.asp
 */

class SpilController {

    //Opretter en spiller
    val spiller = SpilData()
    var spilKategori = ""
        get() = field

    fun getSpillerLiv(): Int {
        return spiller.spillerLiv
    }

    fun getSpillerPoint(): Int {
        return spiller.spillerPoint
    }

    //Drejer hjullet og skaffer en retur værdi. Da der er 24 muligheder, så skal vi bruge et tilfældigt tal mellem 1 og 24.
    fun drejHjullet(): String {

        return spiller.lykkehjul(spiller.ranTal(24))
    }

    //Trækker et tilfældigt ord fra vores ordliste.
    fun getRandomOrd(context: Context): String {

        when (spiller.ranTal(4)) {
            1 -> {
                val ord = context.resources.getStringArray(R.array.blomster).toList()
                spilKategori = "blomster"
                return ord[spiller.ranTal(ord.size - 1)]
            }
            2 -> {
                val ord = context.resources.getStringArray(R.array.dyr).toList()
                spilKategori = "dyr"
                return ord[spiller.ranTal(ord.size - 1)]
            }
            3 -> {
                val ord = context.resources.getStringArray(R.array.groentsager).toList()
                spilKategori = "grøntsager"
                return ord[spiller.ranTal(ord.size - 1)]
            }
            4 -> {
                val ord = context.resources.getStringArray(R.array.toej).toList()
                spilKategori = "tøj"
                return ord[spiller.ranTal(ord.size - 1)]
            }
        }

        return ""
    }

    //Gemmer ordet bag " ☐ ", så spilleren ikke kan se hvad der foregår. ☐ er ALT kode 9744 - https://altcodeunicode.com/
    fun gemOrd(ord: String): String {

        var gemtOrd = ""

        for (i in 1..ord.length) {
            gemtOrd += "☐"
        }

        return gemtOrd
    }

    //@source:  https://www.w3schools.com/java/ref_string_indexof.asp
    fun tjekBogstav(ord: String, gemtOrd: String, bogstav: Char): String {

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

    fun tjekVinder(ord: String, gemtOrd: String): Boolean {
        if (ord == gemtOrd) {
            return true
        }

        return false
    }

    fun tjekTaber(): Boolean {

        if (getSpillerLiv() == 0) {
            return true
        }

        return false
    }
}