# 💰 Budget Tracker Application

## 📌 Project Overview

Budget Tracker is a full-stack web application developed using **Spring Boot**, **Java**, **MySQL**, **HTML**, **CSS**, and **JavaScript**. It helps users manage their personal finances by tracking income and expenses, monitoring budgets, and generating financial reports.

---

## 🚀 Features

### User Module

* User Registration
* User Login
* Dashboard
* Add Income
* View Income
* Add Expense
* View Expenses
* Update Expense
* Delete Expense
* Monthly Expense Report
* Category-wise Expense Report
* Budget Alert
* PDF Report Generation

### Admin Module

* Admin Login
* Dashboard
* View All Users
* View All Income
* View All Expenses
* Total Income
* Total Expense
* Total Users
* Total Transactions
* Delete User Expenses
* Delete User Income

---

## 🛠️ Technologies Used

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* REST API
* Maven

### Frontend

* HTML5
* CSS3
* JavaScript

### Database

* MySQL

### Tools

* Eclipse IDE
* Git
* GitHub
* Railway (Deployment)
* MySQL Workbench

---

## 📂 Project Structure

```text
budgettracker
│
├── src/main/java
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   └── BudgettrackerApplication.java
│
├── src/main/resources
│   ├── application.properties
│   └── static
│
├── frontend
│
├── pom.xml
└── README.md
```

---

## ⚙️ Installation

### Clone the Repository

```bash
git clone https://github.com/your-username/budgettracker.git
```

### Open Project

Open the project using Eclipse or IntelliJ IDEA.

### Configure Database

Update the database configuration in:

```properties
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/budgettracker
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```

### Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the Spring Boot main class from your IDE.

---

## 📷 Screenshots

* Login Page
* Register Page
* User Dashboard
* Add Income
* Add Expense
* Budget Alert
* Reports
* Admin Dashboard

(Add screenshots here after deployment.)

---

## 📌 Future Enhancements

* Email Notifications
* Profile Management
* Expense Charts
* Dark Mode
* Export to Excel
* Mobile Responsive Design

---

## 👩‍💻 Author

**Marisharagavi K**

Java Full Stack Developer

GitHub:
https://github.com/kmarisharagavi-design

---

## 📄 License

This project is developed for learning, portfolio, and educational purposes.
