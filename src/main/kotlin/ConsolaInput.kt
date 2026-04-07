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
            println("Nombre no válido")
        }
    }

    private fun readTimeSlots(): List<TimeSlot> {
        val slots = mutableListOf<TimeSlot>()

        for (i in 1..6) {
            println("\nTramo horario $i")

            while (true) {
                val start = readValidTime("Inicio (HH:15): ")
                val end = readValidTime("Fin (HH:15): ")

                if (isEndAfterStart(start, end)) {
                    slots.add(TimeSlot(start, end))
                    break
                } else {
                    println("La hora de fin debe ser posterior a la de inicio")
                }
            }
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
                        println("Texto no válido")
                    }
                }
            }

            result[slot] = subjectsByDay
        }

        return result
    }

    private fun readValidTime(message: String): String {
        val regex = Regex("""^([01]\d|2[0-3]):15$""")

        while (true) {
            print(message)
            val input = readLine() ?: ""

            if (regex.matches(input)) {
                return input
            } else {
                println("Hora no válida. Debe ser HH:15 (ej: 08:15)")
            }
        }
    }

    private fun isEndAfterStart(start: String, end: String): Boolean {
        val startHour = start.substring(0, 2).toInt()
        val endHour = end.substring(0, 2).toInt()

        return endHour > startHour
    }

    private fun validateText(value: String): Boolean {
        return value.isNotBlank()
    }
}