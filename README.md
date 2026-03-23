# Student-Record-Manager

Project description:  
A Kotlin console application that allows the addition of students details, viewing record of students, calculating average score of students, searching for student by name, with proper application of null safety and checks.

Concepts used:  
- A date class to store students data.
- Mutable list.
- A while loop.
- The when expression.
- For loop.
- While loop.
- Safe calls.
- Null check.
- The trim() function to remove whitespaces inputted by user.

Challenges faced:  
- Where to apply safe calls (?.).
- I used the expression if (name == null) instead of name.isNullOrBlank(). The program will not automatically assign a String to be null if the user does not input a value, it interpretes it as "" (which means name can never be null).
- I did not realize that my functions needed to be defined outside the main function, which caused the program to not recognize them when they were called.

What I learned:  
- The difference between an expression and a statement - an expression returns a value - a statement performs an action(printing, assignment,...).
- Functions have to be defined outside the main function.
- When declaring a variable you must put the data type beside it (e.g. val name: String).
