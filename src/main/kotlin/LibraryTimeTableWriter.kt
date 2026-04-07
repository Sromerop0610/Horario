import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.asciitable.CWC_LongestLine
import TimeTable
import DayOfWeek

class LibraryTimeTableWriter : TimeTableWriter {

    override fun write(timeTable: TimeTable) {
        val table = AsciiTable()

        // Título
        println("HORARIO DEL GRUPO ${timeTable.groupName}\n")

        // Cabecera
        val header = mutableListOf("Hora")
        header.addAll(DayOfWeek.values().map { translateDay(it) })
        table.addRule()
        table.addRow(header)
        table.addRule()

        // Filas
        timeTable.rows.forEach { row ->
            val time = "${row.timeSlot.start}-${row.timeSlot.end}"

            val rowData = mutableListOf<String>()
            rowData.add(time)

            DayOfWeek.values().forEach { day ->
                rowData.add(row.subjectsByDay[day] ?: "")
            }

            table.addRow(rowData)
            table.addRule()
        }

        table.renderer.cwc = CWC_LongestLine()

        println(table.render())
    }

    private fun translateDay(day: DayOfWeek): String {
        return when (day) {
            DayOfWeek.MONDAY -> "Lunes"
            DayOfWeek.TUESDAY -> "Martes"
            DayOfWeek.WEDNESDAY -> "Miércoles"
            DayOfWeek.THURSDAY -> "Jueves"
            DayOfWeek.FRIDAY -> "Viernes"
        }
    }
}