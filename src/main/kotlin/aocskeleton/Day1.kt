package aocskeleton

import aocskeleton.utils.toInts

class Day1 : Day {
    override val index = 1

    override fun partOne(rows: List<String>): Int {
        val rations : MutableList<Int> = mutableListOf(0)

        rows.forEach{
            if (it.isNotEmpty()) {
                rations.add(rations.size, rations.last() + it.toInts(' ').first())
            }
            else {
                rations.add(0)
            }
        }

        return rations.maxOrNull() ?: 0
    }

    override fun partTwo(rows: List<String>): Long {
        val rations : MutableList<Int> = mutableListOf(0)

        rows.forEach{
            if (it.isNotEmpty()) {
                rations.add(rations.size, rations.last() + it.toInts(' ').first())
            }
            else {
                rations.add(0)
            }
        }

        rations.sortDescending()

        return (rations.first() + rations[1] + rations[2]).toLong()
    }
}
