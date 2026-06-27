# Quiz Management System

A desktop-based Quiz Management System developed using Java, Swing, JDBC, and MySQL. The application enables administrators to manage quizzes and students to attempt quizzes and view their results.

---

## Overview

This project is developed using Java Swing for the graphical user interface, JDBC for database connectivity, and MySQL as the backend database. It follows Object-Oriented Programming principles and the DAO (Data Access Object) design pattern for better code organization and maintainability.

---

## Features

### Admin
- Admin Login
- Create Quiz
- Add Questions
- View All Quizzes
- Delete Quiz
- View Student Results

### Student
- Student Registration
- Student Login
- Attempt Quiz
- One Attempt Per Quiz
- View Score
- View Previous Results

---

## Technologies Used

- Java
- Java Swing
- JDBC
- MySQL
- DAO Pattern
- Object-Oriented Programming (OOP)
- Collection Framework
- Exception Handling

---

## Project Structure

```
src/main/java
│
├── quizmanagementsystem.dao
├── quizmanagementsystem.daoimpl
├── quizmanagementsystem.Exception
├── quizmanagementsystem.main
├── quizmanagementsystem.model
└── quizmanagementsystem.util
```

---

## Database

Database Name:
```
quiz_management
```

Tables:
- users
- quizzes
- questions
- attempt
- results

---

## How to Run
1. Clone the repository.
2. Create the MySQL database.
3. Import the SQL file.
4. Update the database credentials in `DbUtil.java`.
5. Run `Main.java`.

---

## Future Enhancements
- Quiz Timer
- Password Encryption
- Leaderboard
- Random Question Generation
- Export Results

---

## Author

**Deepesh Jangid**
