class ConsoleInput {

    fun readData(): TimeTableInputData {
        val groupName = readGroupName()
        val timeSlots = readTimeSlots()
        val subjects = readSubjects(timeSlots)

        return TimeTableInputData(
            groupName = groupName,
            timeSlots = timeSlots,
            subjectsBySlot = subjects
        )
    }

    private fun readGroupName(): String {
        while (true) {
            print("Introduce el nombre del grupo: ")
            val input = readLine() ?: ""

            if (validateText(input)) return input
            println("❌ Nombre no válido")
        }
    }

    private fun readTimeSlots(): List<TimeSlot> {
        val slots = mutableListOf<TimeSlot>()

        for (i in 1..6) {
            println("Tramo horario $i")
            print("Inicio: ")
            val start = readLine() ?: ""

            print("Fin: ")
            val end = readLine() ?: ""

            slots.add(TimeSlot(start, end))
        }

        return slots
    }

    private fun readSubjects(
        timeSlots: List<TimeSlot>
    ): Map<TimeSlot, Map<DayOfWeek, String>> {

        val result = mutableMapOf<TimeSlot, Map<DayOfWeek, String>>()

        timeSlots.forEachIndexed { index, slot ->
            println("\n--- Hora ${index + 1} (${slot.start}-${slot.end}) ---")

            val subjectsByDay = mutableMapOf<DayOfWeek, String>()

            for (day in DayOfWeek.values()) {
                while (true) {
                    print("${day.name}: ")
                    val subject = readLine() ?: ""

                    if (validateText(subject)) {
                        subjectsByDay[day] = subject
                        break
                    } else {
                        println("❌ Texto no válido")
                    }
                }
            }

            result[slot] = subjectsByDay
        }

        return result
    }

    private fun validateText(value: String): Boolean {
        return value.isNotBlank()
    }
}