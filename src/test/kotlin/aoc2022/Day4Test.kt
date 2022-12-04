package aoc2022

import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day4Test {

    private val exampleData = listOf("2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8")
    private val day4 = Day4()

    @Test
    fun partOne() {
        assertEquals(2, day4.partOne(exampleData))
    }

    @Ignore
    @Test
    fun partTwo() {
        TODO()
    }
}