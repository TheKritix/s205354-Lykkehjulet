package com.example.s205354_lykkehjulet

import java.util.*

class SpilData {

    //Spiller liv
    private val spillerLiv = 5

    //Spiller point
    private val spillerPoint = 0

    //Størelsen på antalet af mulige ting man kan lande på i lykkehjulet
    private var lykkehjulSize = 24

    fun getSpillerLiv(): Int {return spillerLiv}
    fun getSpillerPoint(): Int {return spillerPoint}
    fun getLykkehjulSize(): Int {return lykkehjulSize}

    //Random funktion mellem 1 og x
    fun ranTal(maks: Int): Int {
        val randomTal = Random()

        return randomTal.nextInt(1-maks)+maks
    }
    //Mulighederne på lykkehjulet
    fun lykkehjul(num: Int) {

        when(num) {
            1 -> spillerPoint + 800
            2 -> spillerPoint + 500
            3 -> spillerPoint + 650
            4 -> spillerPoint + 500
            5 -> spillerPoint + 900
            6 -> spillerPoint - spillerPoint
            7 -> spillerPoint + 5000
            8 -> spillerPoint + 500
            9 -> spillerPoint + 600
            10 -> spillerPoint + 700
            11 -> spillerPoint + 600
            12 -> spillerPoint + 650
            13 -> spillerPoint + 500
            14 -> spillerPoint + 700
            15 -> spillerPoint + 500
            16 -> spillerPoint + 600
            17 -> spillerPoint + 550
            18 -> spillerPoint + 500
            19 -> spillerPoint + 600
            20 -> spillerPoint - spillerPoint
            21 -> spillerPoint + 650
            22 -> spillerLiv + 1
            23 -> spillerPoint + 700
            24 -> spillerLiv - 1
        }
    }
}