package com.example.s205354_lykkehjulet

import android.content.Context
import android.content.res.Resources
import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.manipulation.Ordering

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun spilControllerTest(){

        val ord = "Test"
        val spil = SpilController()
        val stringTest = spil.getSpillerPoint().toString()
        assertEquals(spil.gemOrd(ord).length, ord.length)
        assertEquals(spil.getSpillerPoint(), 0)
        assertEquals(stringTest, "0")
    }
}