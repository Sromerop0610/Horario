class LibraryTimeTableWriter : TimeTableWriter {
    override fun write(timeTable: TimeTable) {
        println("Mostrando horario (versión simple):")

        timeTable.rows.forEach {
            println("${it.timeSlot.start}-${it.timeSlot.end} -> ${it.subjectsByDay}")
        }
    }
}