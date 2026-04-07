class TimeTableManager(
    private val input: ConsoleInput,
    private val builder: TimeTableBuilder,
    private val writer: TimeTableWriter
) {
    fun execute() {
        val data = input.readData()
        val timetable = builder.build(data)
        writer.write(timetable)
    }
}