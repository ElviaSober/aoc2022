package aoc2022.utils

/**
 * Use on a row.
 */
fun String.toInts(delimiter: Char): List<Int> = this.split(delimiter).map { it.trim().toInt() }

/**
 * Use on rows.
 */
fun List<String>.eachCharToInt(): List<List<Int>> = this.map { row -> row.trim().map(Char::digitToInt) }
