package aoc2022

class Day3 : Day {
    override val index = 3

    override fun partOne(rows: List<String>): Int {
        return rows.fold(0) { acc, row ->
            val rucksack1 = row.substring(0, row.length / 2)
            val rucksack2 = row.substring(row.length / 2, row.length)
            acc + rucksack1.intersectWithRucksack(rucksack2).first().calculateValue()
        }
    }

    private fun Char.calculateValue() =
        if (this.isLowerCase()) this.code - 96
        else this.code - 38

    private fun String.intersectWithRucksack(rucksack: String) = this.toCharArray().intersect(rucksack.toSet())

    override fun partTwo(rows: List<String>): Long {
        return rows.chunked(3).fold(0) { acc, group ->
            acc + group[0].intersectWithRucksack(group[1])
                .intersect(group[2].toSet())
                .first().calculateValue()
        }
    }
}
