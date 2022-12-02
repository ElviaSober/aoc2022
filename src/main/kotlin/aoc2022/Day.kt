package aoc2022

interface Day {

    val index: Int

    fun partOne(rows: List<String>): Int

    fun partTwo(rows: List<String>): Long
}