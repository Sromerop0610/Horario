fun main() {

    val slot1 = TimeSlot("08:00", "09:00")
    val slot2 = TimeSlot("09:00", "10:00")

    val subjectsSlot1 = mapOf(
        DayOfWeek.MONDAY to "Math",
        DayOfWeek.TUESDAY to "History"
    )

    val subjectsSlot2 = mapOf(
        DayOfWeek.MONDAY to "English",
        DayOfWeek.TUESDAY to "PE"
    )

    val inputData = TimeTableInputData(
        groupName = "1DAW",
        timeSlots = listOf(slot1, slot2),
        subjectsBySlot = mapOf(
            slot1 to subjectsSlot1,
            slot2 to subjectsSlot2
        )
    )

    val builder = TimeTableBuilder()
    val timetable = builder.build(inputData)

    println(timetable)
}

