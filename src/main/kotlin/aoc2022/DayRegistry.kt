package aoc2022

import kotlin.collections.listOf

object DayRegistry {
    fun loadDays() = listOf(
        Day1(),
        Day2(),
        Day3(),
        Day4(),
        Day5()
    )
}
