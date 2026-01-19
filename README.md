# Student Management Backend

## Overview
This project is a Java-based backend application that performs CRUD (Create, Read, Update, Delete) operations for a student management system.  
It manages students, professors, subjects, admissions, and their relationships using a relational database.

The application exposes RESTful APIs and follows standard backend architecture and best practices.

---

## Domain Model
The system is built around the following core entities:

- **Student**
- **Professor**
- **Subject**
- **Admission Record**
- **Student–Subject Mapping**
- **Professor–Student Mapping**

The database schema supports:
- One-to-many relationships (Student → Admission Record)
- Many-to-many relationships (Student ↔ Subject, Professor ↔ Student)

---

## Tech Stack
- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Maven
- **Database:** MySQL / PostgreSQL (configurable)
- **ORM:** Hibernate / JPA
- **API Style:** REST
- **Testing:** JUnit / Mockito (optional)

---

## Database Schema
### Tables
- `student (id, name)`
- `professor (id, title)`
- `subject (id, title, professor_id)`
- `admission_record (id, fees, student_id)`
- `student_subject (student_id, subject_id)`
- `professor_student (professor_id, student_id)`

All relationships are enforced using foreign keys.

---

## Prerequisites
Ensure the following are installed:
- Java 21 (or required version)
- Maven 3.8+
- Git
- PostgreSQL

---

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/your-username/student-management-backend.git
cd student-management-backend
