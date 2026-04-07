class TimeTableBuilder {

    fun build(inputData: TimeTableInputData): TimeTable {

        val rows = mutableListOf<TimeTableRow>()

        // Recorremos el map y creamos cada fila
        for ((timeSlot, subjectsByDay) in inputData.subjectsBySlot) {
            val row = TimeTableRow(
                timeSlot = timeSlot,
                subjectsBySlot = subjectsByDay
            )
            rows.add(row)
        }

        return TimeTable(
            groupName = inputData.groupName,
            rows = rows
        )
    }
    private fun validateStructure(inputData: TimeTableInputData) {
        // Grupo no vacío
        require(inputData.groupName.isNotBlank()) {
            "El nombre del grupo no puede estar vacío"
        }

        // 6 tramos horarios
        require(inputData.timeSlots.size == 6) {
            "Debe haber exactamente 6 tramos horarios"
        }

        // Cada tramo debe tener 5 días
        inputData.timeSlots.forEach { slot ->
            val subjects = inputData.subjectsBySlot[slot]
                ?: throw IllegalArgumentException("Faltan asignaturas para un tramo horario")

            require(subjects.size == DayOfWeek.values().size) {
                "Cada tramo debe tener 5 asignaturas (una por día)"
            }

            // Ninguna asignatura vacía
            subjects.forEach { (_, subject) ->
                require(subject.isNotBlank()) {
                    "Las asignaturas no pueden estar vacías"
                }
            }
        }
    }
}