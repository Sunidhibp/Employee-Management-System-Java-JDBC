# Employee Management System (Java + JDBC)

A console-based Employee Management System built using **Java**, **JDBC**, and **MySQL**.  
This project demonstrates CRUD operations, DAO design pattern, secure database connectivity, and clean project structuring.

---

## 🚀 Features

- Add a New Employee: Insert employee records into the MySQL database.

- View All Employees: Fetch and display all stored records in a formatted list.

- Update Employee Salary: Modify existing salary details securely.

- Delete Employee: Remove records with a built-in confirmation prompt to prevent accidental data loss.

- Menu-Driven Console Interface: Easy navigation through a CLI-based menu.

- Secure Database Connection: Implements environment variable-based credential management.

---

## 🛠 Tech Stack

- Java (JDK 17+)
- MySQL
- JDBC (MySQL Connector/J)
- IntelliJ IDEA
- Git & GitHub

---

## 📁 Project Structur

EmployeeManagementSystem  
│  
├── src  
│   ├── dao  
│   │   └── EmployeeDAO.java        # Handles all database operations (CRUD)  
│   ├── model  
│   │   └── Employee.java           # Employee entity / model class  
│   ├── util  
│   │   └── DBConnection.java       # MySQL database connection utility  
│   └── main  
│       └── MainApp.java            # Application entry point (menu-driven)  
│  
├── .gitignore                      # Git ignored files  
├── README.md                       # Project documentation  
└── EmployeeManagementSystem.iml    # IntelliJ IDEA project file  


---

## 🧩 Database Schema

CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    salary DOUBLE CHECK (salary > 0)
);

---

## 🔐 Security Note
As a Cybersecurity enthusiast, I have ensured that database credentials are NOT hardcoded in the source code. The application retrieves credentials using environment variables:

Java

System.getenv("DB_USER");
System.getenv("DB_PASSWORD");

Why this matters:
Confidentiality: Passwords are not exposed on GitHub or in public repositories.
Compliance: Follows real-world security practices for backend development.
Portability: Safe for public sharing without compromising local database security.

---

## ⚙️ How to Run the Project
## 1️⃣ Prerequisites

Java JDK 17+
MySQL installed and running
IntelliJ IDEA
MySQL Connector/J added to project dependencies

---

## 2️⃣ Set Environment Variables

setx DB_USER root
setx DB_PASSWORD your_mysql_password


Restart IntelliJ after setting variables.

---

## 3️⃣ Run the Application

Open MainApp.java
Click ▶ Run
Use the menu to perform operations

---


## 📌 Sample Output
===== Employee Management System =====
1. Add Employee
2. View Employees
3. Update Salary
4. Delete Employee
5. Exit
Choose option: 2

📋 Employee List:
1 | Sunidhi | IT | 45000.0

---

## 🧠 Concepts Demonstrated

JDBC connectivity
DAO (Data Access bject) pattern
Exception handling
Clean code & modular design
Secure credential handling
Git version control

---

## 👩‍💻 Author

Sunidhi
B.Tech CSE (Cyber Security)
Aspiring Software / Backend Developer

---

## ⭐ Future Enhancements

Input validation
Logging instead of System.out.println
Maven/Gradle build
REST API version (Spring Boot)
Role-based access

---

## ⭐ If you found this project useful, feel free to star the repository!
