// A student record manager using mutable list to store student data

val names = mutableListOf<String>()
val ages = mutableListOf<Int>()
val scores = mutableListOf<Double>()

fun main() {
    var running = true

    while (running) {
        println("--- Student Record Manager ---")
        println("1. Add Student Record")
        println("2. Display All Students")
        println("3. Find Student by Name")
        println("4. Calculate Average Score")
        println("5. Delete Student Record")
        println("6. Exit")
        println("Please select an option: ")

        when (readLine()) {
            "1" -> addStudent()
            "2" -> displayStudents()
            "3" -> findStudent()
            "4" -> calculateAverage()
            "5" -> deleteStudent()
            "6" -> {
                println("Goodbye")
                running = false
            }
        }
    }
}

fun addStudent() {
    println("Enter Student Name: ")
    val name = readLine()?.trim()

    if (name.isNullOrBlank()) {
        println("Name cannot be empty.")
        return
    }

    println("Enter Student Age: ")
    val age = readLine()?.toIntOrNull()

    println("Enter Student Score (0-100): ")
    val score = readLine()?.toDoubleOrNull()

    if (age == null || score == null) {
        println("Age and score must be valid numbers. Student not added.")
    } else {
        names.add(name)
        ages.add(age)
        scores.add(score)
        println("Student added.")
    }

}

fun displayStudents() {
    if (names.isEmpty()) {
        println("No record available.")
    } else {
        println("--- All Students Record ---")
        for (i in names.indices) {
            println("Name: ${names[i]} \t Age: ${ages[i]} \t Score: %.2f".format(scores[i]))
        }
    }
}

fun findStudent() {
    if (names.isEmpty()) {
        println("No record available.")
        return
    }

    println("Enter Student Name: ")
    val searchName = readLine()?.trim()

    if (searchName.isNullOrBlank()) {
        println("Please input a name.")
        return
    }

    val foundStudent = names.indexOfFirst { it.equals(searchName, ignoreCase = true) }

    if (foundStudent == -1) {
        println("Student not found.")
    } else {
        println("Name: ${names[foundStudent]} \t Age: ${ages[foundStudent]} \t Score: %.2f".format(scores[foundStudent]))
    }


}

fun calculateAverage() {
    if (names.isEmpty()) {
        println("No record available.")
    } else {
        val average = scores.sum() / scores.size
        println("The average score is %.2f".format(average))
    }
}

fun deleteStudent() {
    if (names.isEmpty()) {
        println("No record available.")
        return
    }

    println("Enter Student Name: ")
    val searchName = readLine()?.trim()

    if (searchName.isNullOrBlank()) {
        println("Name cannot be empty.")
        return
    }

    val delStudent = names.indexOfFirst { it.equals(searchName, ignoreCase = true) }

    if (delStudent == -1) {
        println("Student not found.")
    } else {
        println("Name: ${names[delStudent]} \t Age: ${ages[delStudent]} \t Score: %.2f".format(scores[delStudent]))
        println("Are you sure you want to delete this record? y/n")
        val confirmDelete = readLine()?.trim()

        if (confirmDelete.isNullOrBlank()) {
            println("Input an option.")
        } else if (confirmDelete.equals("y", ignoreCase = true)) {
            names.removeAt(delStudent)
            ages.removeAt(delStudent)
            scores.removeAt(delStudent)
            println("Record deleted.")
        } else if (confirmDelete.equals("n", ignoreCase = true)) {
            println("Record not deleted.")
        } else println("Input a valid option.")
    }
}

