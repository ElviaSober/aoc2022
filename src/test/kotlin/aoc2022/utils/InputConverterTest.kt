package aoc2022.utils

import assertk.assertThat
import assertk.assertions.containsExactly
import org.junit.Test

internal class InputConverterTest {

    @Test
    fun testRowToInts() {
        assertThat("1, 2, 3 ".toInts(','))
            .containsExactly(1,2,3)
    }

    @Test
    fun testEachCharInEachRowToInt() {
        assertThat(listOf(" 123 "," 456 ").eachCharToInt())
            .containsExactly(listOf(1,2,3), listOf(4,5,6))
    }
}