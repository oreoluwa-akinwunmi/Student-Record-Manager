data class Student(val name: String, val age: Int, val score: Double)

val students = mutableListOf<Student>()

fun main() {
    var running = true

    while (running) {
        println("--- Student Record Manager ---")
        println("1. Add Student Record")
        println("2. Display All Students")
        println("3. Find Student by Name")
        println("4. Calculate Average Score")
        println("5. Exit")
        print("Choose an option: ")

        when (readLine()) {
            "1" -> addStudent()
            "2" -> displayStudents()
            "3" -> findStudent()
            "4" -> calculateAverage()
            "5" -> {
                println("Goodbye")
                running = false
            }
            else -> println("Invalid Option")
        }
    }
}


fun addStudent() {
    println("Enter Student Name: ")
    val name = readLine()?.trim()
    if (name.isNullOrBlank()) {
        println("Name cannot be empty."); return
    }

    println("Enter Student Age: ")
    val age = readLine()?.toIntOrNull()

    println("Enter Student Score (0-100): ")
    val score = readLine()?.toDoubleOrNull()

    if (age == null || score == null) {
        println("Age and Score must be valid numbers. Student not added.")
    } else {
        students.add(Student(name, age, score))
        println("Student successfully added.")
    }
}

fun displayStudents() {
    if (students.isNotEmpty()) {
        println("--- All Students --")
        for (student in students) {
            println("Name: ${student.name} \t Age: ${student.age} \t Score: ${student.score}") // make the displayed result be refined
        }
    } else {
        println("No student found. Please enter a student record")
    }

}

fun findStudent() {
    println("Enter Student Name: ")
    val searchName = readLine()?.trim()

    val foundStudent = students.find {it.name.equals(searchName, true) }

    if (searchName.isNullOrBlank()) {
        println("Invalid input")
    } else if (foundStudent != null) {
        println("--- Found Student ---")
        println("Name: ${foundStudent.name}, Age: ${foundStudent.age}, Score: ${foundStudent.score}") // make the displayed result be refined
    } else {
        println("Sorry, student record could not be found.")
    }
}

fun calculateAverage() {
    if (students.isEmpty()) {
        println("Please enter a student detail first")
    } else {
        val average = students.sumOf {it.score} / students.size
        println("The average score is: %.2f".format(average)) // converts to 2 decimal places
    }

}