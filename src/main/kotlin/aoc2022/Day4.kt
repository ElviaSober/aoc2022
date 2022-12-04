package aoc2022

class Day4 : Day {
    override val index = 4

    override fun partOne(rows: List<String>): Int {
        return rows.countOverlaps { assignmentsPerElf ->
            assignmentsPerElf[0].all { assignmentsPerElf[1].contains(it) } || assignmentsPerElf[1].all { assignmentsPerElf[0].contains(it) }
        }
    }

    override fun partTwo(rows: List<String>): Long {
        return rows.countOverlaps { assignmentsPerElf ->
            assignmentsPerElf[0].any { assignmentsPerElf[1].contains(it) }
        }.toLong()
    }

    private fun List<String>.countOverlaps(predicate: (List<IntRange>) -> Boolean): Int {
        return this.count { row ->
            val assignmentsPerElf = row.split(',').map { range ->
                val rangeStartEnd = range.split('-')
                IntRange(rangeStartEnd[0].toInt(), rangeStartEnd[1].toInt())
            }
            predicate(assignmentsPerElf)
        }
    }
}