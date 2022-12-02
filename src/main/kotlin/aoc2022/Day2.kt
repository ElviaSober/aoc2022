package aoc2022

import java.lang.IllegalArgumentException

class Day2 : Day {
    override val index = 2

    override fun partOne(rows: List<String>): Int {
        return rows.fold(0) { acc, row ->
            val values = row.split(' ')
            val hisShapeValue = values[0].first().shapeValue()
            val myShapeValue = values[1].first().shapeValue()
            acc + myShapeValue + hisShapeValue.against(myShapeValue)
        }
    }

    override fun partTwo(rows: List<String>): Long {
        return rows.fold(0) { acc, row ->
            val values = row.split(' ')
            val hisShapeValue = values[0].first().shapeValue()
            acc + when (values[1].first().lowercaseChar()) {
                'y' -> hisShapeValue + 3
                'x' -> if (hisShapeValue == 1) 3 else (hisShapeValue - 1)
                'z' -> if (hisShapeValue == 3) 7 else (hisShapeValue + 7)
                else -> {
                    throw IllegalArgumentException(values[1])
                }
            }
        }
    }

    private fun Char.shapeValue() = when (this.lowercaseChar()) {
        'x', 'a' -> 1
        'y', 'b' -> 2
        'z', 'c' -> 3
        else -> {
            throw IllegalArgumentException()
        }
    }

    /**
     * Return the score for ME for the round.
     */
    private fun Int.against(myShapeValue: Int): Int {
        if (this == myShapeValue) return 3
        if (this + 1 == myShapeValue || (this - myShapeValue == 2)) return 6
        return 0
    }
}