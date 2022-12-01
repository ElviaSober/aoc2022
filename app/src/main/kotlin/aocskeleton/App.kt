package aocskeleton

import kotlin.system.exitProcess

class App

fun main() {

    println("Enter number of the day: ")
    val numberOfDay = readLine()!!
    if (!isValidInputNumber(numberOfDay)) {
        exitGracefully("Day number $numberOfDay is invalid. 1-25 are valid values.")
    }

    val day = DayRegistry.loadDays().find { it.index == numberOfDay.toInt() }
        ?: exitGracefully("Day $numberOfDay has not been implemented yet.")

    val lines = App::class.java.getResourceAsStream("InputDay$numberOfDay.txt")?.bufferedReader()?.readLines()
        ?: exitGracefully("File with name InputDay$numberOfDay does not exist.")

    if (lines.isEmpty()) exitGracefully("File InputDay$numberOfDay is empty. Are you sure you added your puzzle input into it?")

    println("Enter number of the part: ")
    val numberOfPart = readLine()!!

    println(
        "Answer: ${
            when (numberOfPart) {
                "1" -> day.partOne(lines)
                "2" -> day.partTwo(lines)
                else -> exitGracefully("Invalid number of the part: $numberOfPart.")
            }
        }"
    )
}

private fun isValidInputNumber(numberOfDay: String): Boolean {
    var valid = true;
    try {
        if (numberOfDay.isEmpty() || numberOfDay.toInt() > 25 || numberOfDay.toInt() < 1) {
            valid = false
        }
    } catch (e: NumberFormatException) {
        valid = false
    }
    return valid
}

private fun exitGracefully(message: String): Nothing {
    println("ERROR: $message")
    exitProcess(0)
}