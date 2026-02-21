# Student Management REST API

## 🚀 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Postman

## 📌 Project Description
This project is a complete REST API built using Spring Boot and MySQL.
It performs CRUD operations on Student data with validation and global exception handling.

## 🗄️ Database Setup
1. Create MySQL database:
   CREATE DATABASE student_db;

2. Configure application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword

## 📡 API Endpoints

POST   /api/students  
GET    /api/students  
GET    /api/students/{id}  
PUT    /api/students/{id}  
DELETE /api/students/{id}

## ✅ Features
- CRUD Operations
- RESTful API
- Validation using annotations
- Global Exception Handling
- Proper HTTP Status Codes
- MVC Architecture


##screenshots
📸 MySQL table
<img width="491" height="411" alt="image" src="https://github.com/user-attachments/assets/56dff8dd-c4af-472e-9b52-a876ea371340" />
<img width="664" height="443" alt="image" src="https://github.com/user-attachments/assets/d9bb09f3-a5ef-4c24-a46d-aaee0d371643" />

📸 POST request
<img width="889" height="580" alt="image" src="https://github.com/user-attachments/assets/4505399b-4717-461a-921a-ed4555e05c8b" />

📸 GET request
<img width="839" height="632" alt="image" src="https://github.com/user-attachments/assets/3db3a5fb-d183-4f71-a9d0-6be9a1660eec" />

📸 PUT request
<img width="858" height="579" alt="image" src="https://github.com/user-attachments/assets/7e6a9e89-f01b-4b96-b09f-01d47b7e4f45" />

📸 DELETE request
<img width="867" height="543" alt="image" src="https://github.com/user-attachments/assets/7b46d903-c47f-4c87-9c23-364caa3137ac" />



