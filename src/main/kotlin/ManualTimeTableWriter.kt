class ManualTimeTableWriter : TimeTableWriter {

    private val cellWidth = 22
    private val timeWidth = 15

    override fun write(timeTable: TimeTable) {
        printHeader(timeTable.groupName)
        printTable(timeTable)
    }

    private fun printHeader(groupName: String) {
        println("=".repeat(62))
        println("      HORARIO DEL GRUPO $groupName")
        println("=".repeat(62))
        println()
    }

    private fun printTable(timeTable: TimeTable) {
        val days = DayOfWeek.values()

        printSeparator()
        println(
            formatCell("Hora", timeWidth) +
                    days.joinToString("") { formatCell(it.name, cellWidth) }
        )
        printSeparator()

        timeTable.rows.forEach { row ->
            val timeText = "${row.timeSlot.start}-${row.timeSlot.end}"

            val line = formatCell(timeText, timeWidth) +
                    days.joinToString("") { day ->
                        formatCell(row.subjectsByDay[day] ?: "", cellWidth)
                    }

            println(line)
        }

        printSeparator()
    }

    private fun printSeparator() {
        println(
            "+" + "-".repeat(timeWidth - 1) + "+" +
                    "-".repeat(cellWidth * DayOfWeek.values().size + DayOfWeek.values().size)
        )
    }

    private fun formatCell(text: String, width: Int): String {
        val trimmed = if (text.length > width - 2)
            text.substring(0, width - 3) + "…"
        else text

        return "| " + trimmed.padEnd(width - 2, ' ')
    }
}