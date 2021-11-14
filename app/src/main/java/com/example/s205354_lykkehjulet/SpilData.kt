package com.example.s205354_lykkehjulet

import java.util.*

class SpilData {

    //Spiller liv
    var spillerLiv = 5
        get() = field

    //Spiller point
    var spillerPoint = 0
        get() = field

    var tempSpillerPoint = 0

    //Størelsen på antalet af mulige ting man kan lande på i lykkehjulet
    private val lykkehjulSize = 24

    //Random funktion mellem 1 og x
    fun ranTal(maks: Int): Int {
        val randomTal = Random()

        return randomTal.nextInt((maks+ 1 )-1) + 1
    }
    //Mulighederne på lykkehjulet
    fun lykkehjul(num: Int): String{

        tempSpillerPoint = 0
        var tempSpillerLiv = 0

        when(num) {
            1 -> tempSpillerPoint = 800
            2 -> tempSpillerPoint = 500
            3 -> tempSpillerPoint = 650
            4 -> tempSpillerPoint = 500
            5 -> tempSpillerPoint = 900
            6 -> spillerPoint = 0
            7 -> tempSpillerPoint = 5000
            8 -> tempSpillerPoint = 500
            9 -> tempSpillerPoint = 600
            10 -> tempSpillerPoint = 700
            11 -> tempSpillerPoint = 600
            12 -> tempSpillerPoint = 650
            13 -> tempSpillerPoint = 500
            14 -> tempSpillerPoint = 700
            15 -> tempSpillerPoint = 500
            16 -> tempSpillerPoint = 600
            17 -> tempSpillerPoint = 550
            18 -> tempSpillerPoint = 500
            19 -> tempSpillerPoint = 600
            20 -> spillerPoint = 0
            21 -> tempSpillerPoint = 650
            22 -> tempSpillerLiv = 1
            23 -> tempSpillerPoint = 700
            24 -> tempSpillerLiv = -1
        }

        skiftSpillerLiv(tempSpillerLiv)

        if (tempSpillerLiv > 0) {return "Du fik " + tempSpillerLiv.toString() + " liv"}

        else if (tempSpillerLiv < 0 ) {return "Du mistede " + tempSpillerLiv.toString() + " liv"}

        else if (tempSpillerPoint == 0) {return "Du gik bankeråt"}

        else  {return "Du fik " + tempSpillerPoint.toString() + " point"}

    }
    fun increaseSpillerPoint(){

        spillerPoint = spillerPoint + tempSpillerPoint
    }

    fun skiftSpillerLiv(skiftHP: Int) {
        spillerLiv = spillerLiv + skiftHP
    }
}