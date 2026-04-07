fun main() {

    val input = ConsoleInput()
    val builder = TimeTableBuilder()

    println("¿Cómo quieres mostrar el horario?")
    println("1. Formato manual")
    println("2. Usando librería")
    print("Elige una opción (1 o 2): ")

    val option = readLine()

    val writer: TimeTableWriter = when (option) {
        "1" -> ManualTimeTableWriter()
        "2" -> LibraryTimeTableWriter()
        else -> {
            println("Opción no válida, se usará formato manual por defecto.")
            ManualTimeTableWriter()
        }
    }

    val manager = TimeTableManager(input, builder, writer)
    manager.execute()
}