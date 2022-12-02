package aocskeleton

import kotlin.collections.listOf

object DayRegistry {
    fun loadDays() = listOf(
            Day1(),
        Day2()
    )
}
