package aoc2022

class Day5 : Day {
    override val index = 5

    private val stacks = listOf(
        mutableListOf('z', 'j', 'n', 'w', 'p', 's'),
        mutableListOf('g', 's', 't'),
        mutableListOf('v', 'q', 'r', 'l', 'h'),
        mutableListOf('v', 's', 't', 'd'),
        mutableListOf('q', 'z', 't', 'd', 'b', 'm', 'j'),
        mutableListOf('m', 'w', 't', 'j', 'd', 'c', 'z', 'l'),
        mutableListOf('l', 'p', 'm', 'w', 'g', 't', 'j'),
        mutableListOf('n', 'g', 'm', 't', 'b', 'f', 'q', 'h'),
        mutableListOf('r', 'd', 'g', 'c', 'p', 'b', 'q', 'w')
    )


    override fun partOne(rows: List<String>): Int {
        println("Initial stack: ")
        stacks.forEach { print(it.last().uppercaseChar()) }

        rows.forEach { row ->
            val instruction = row.split(' ')
            for (i in 1 .. instruction[1].toInt()) {
                stacks[instruction[5].toInt() - 1].add(stacks[instruction[3].toInt() - 1].removeLast())
            }
        }

        println("\nFinal stack: ")
        stacks.forEach { print(it.last().uppercaseChar()) }
        println('\n')

        return 0
    }

    override fun partTwo(rows: List<String>): Long {
        println("Initial stack: ")
        stacks.forEach { print(it.last().uppercaseChar()) }

        rows.forEach { row ->
            val instruction = row.split(' ')
            for (i in instruction[1].toInt() downTo 1) {
                stacks[instruction[5].toInt() - 1].add(stacks[instruction[3].toInt() - 1].removeAt(stacks[instruction[3].toInt() - 1].size - i))
            }
        }

        println("\nFinal stack: ")
        stacks.forEach { print(it.last().uppercaseChar()) }
        println('\n')

        return 0
    }
}