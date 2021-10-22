package com.example.s205354_lykkehjulet

class SpilController {

    val spiller = SpilData()

    fun drejHjullet(): Int {
        spiller.lykkehjul(spiller.ranTal())

        return spiller.getSpillerLiv()
    }

    fun getRandomOrd(): String {

        return ""
    }

}