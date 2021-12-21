package day06

fun passDays(days: Int, timers: MutableMap<Int, Long>) {
    repeat(days) { passDay(timers) }
}

fun passDay(timers: MutableMap<Int, Long>) {
    val numberOfProcreators = timers[0] ?: 0
    (0..8).forEach { key ->
        when (key) {
            6 -> timers[key] = (timers[key + 1] ?: 0) + numberOfProcreators
            8 -> timers[key] = numberOfProcreators
            else -> timers[key] = timers[key + 1] ?: 0
        }
    }
}

fun convertToTimers(input: String) = input
    .split(',')
    .asSequence()
    .map(String::trim)
    .map(String::toInt)
    .groupingBy { it }
    .eachCount()
    .mapValues { it.value.toLong() }
    .toMutableMap()