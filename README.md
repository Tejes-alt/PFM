README

1. Project Overview
   This project is a console-based Java application developed as part of the Assessment and Acceptance Checklist. The application is completely non-web and works using a command-line interface. It demonstrates Java fundamentals, object-oriented programming concepts, file handling, and basic software engineering practices. Users interact with the system through a menu-driven flow.

2. Project Objectives

1) To build a menu-driven CLI-based Java application.
2) To apply object-oriented programming concepts such as interfaces, abstract classes, and inheritance.
3) To read input from both the keyboard and files.
4) To write output to the console, text files, and CSV files.
5) To use collections, streams, custom exceptions, logging, and unit testing.
6) To follow proper project structure and build standards.

3. Technologies Used

1) Programming Language: Java
2) Build Tool: Maven or Gradle
3) IDE: VS Code or IntelliJ IDEA
4) Testing Framework: JUnit
5) Version Control: Git and GitHub

4. Project Structure

1) src/main/java contains application source code.
2) src/test/java contains unit test classes.
3) reports folder contains generated CSV and TXT reports.
4) out folder contains application output files.
5) pom.xml or build.gradle manages project dependencies and build.
6) README.txt provides project documentation.

5. Functional Features

1) Console-based CLI menu is implemented without using web technologies.
2) Program flow is controlled using loops.
3) Input is read from the keyboard and external files.
4) Output is written to the console, text files, and CSV files.
5) All reports are generated inside the out or reports directory.

6. Engineering Features

1) Object-oriented programming is used with interfaces, abstract classes, and inheritance.
2) Java Collections such as ArrayList and HashMap are used.
3) Streams API is used for data processing.
4) Custom exceptions are implemented with meaningful error messages.
5) Logging is implemented for tracking application activities.
6) Unit tests are written, including at least one file input/output test.
7) The project builds and runs using a single Maven or Gradle command.

7. Design Pattern Used

1) Singleton Design Pattern is implemented.
2) It ensures that only one instance of shared resources such as logger or file manager exists.
3) It helps in centralized control and efficient resource usage.

8. Sample Input

1) User enters username and password.
2) Menu options are displayed such as check balance, deposit, withdraw, and exit.

9. Sample Output

1) Console displays current balance and transaction status.
2) Data is stored in CSV and TXT files inside the reports folder.

10. Sample CSV Format

1) Date, TransactionType, Amount, CurrentBalance
2) 2025-01-10, DEPOSIT, 1000, 6000
3) 2025-01-11, WITHDRAW, 500, 5500

11. Input Validation

1) Invalid inputs such as negative values are rejected.
2) Proper error messages are displayed for incorrect input.
3) Username and password are validated.

12. Testing

1) Unit tests are written using JUnit.
2) Tests include logic validation and file read/write validation.

13. How to Run the Project

1) Using Maven: mvn clean install and mvn exec:java
2) Using Gradle: gradle build and gradle run

14. Contributors

1) P. Showkath 
2) J. Tejes
3) SK. Jaheersha

15. Conclusion
    This project fulfills the Assessment and Acceptance Checklist requirements by implementing correct functionality, clean code structure, and proper engineering practices. It demonstrates practical usage of Java for real-world console-based applications.

