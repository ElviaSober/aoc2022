package aocskeleton

import kotlin.collections.listOf

object DayRegistry {
    fun loadDays() = listOf<Day>(
            Day1()
    )
}
