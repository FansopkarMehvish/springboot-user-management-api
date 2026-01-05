Spring Boot User Management API

A production-style Spring Boot REST API for managing users, built to demonstrate clean backend architecture, pagination, sorting, validation, DTO mapping, and centralized exception handling.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen)
![REST API](https://img.shields.io/badge/API-REST-blue)
![Backend](https://img.shields.io/badge/Type-Backend-informational)

--------------------------------------------------

FEATURES

- Create user with validation and duplicate email check
- Fetch users with pagination and dynamic sorting
- Fetch user by email
- Centralized global exception handling
- DTO-based request and response model
- Entity-to-DTO mapping using MapStruct
- Database indexing for performance and data integrity

--------------------------------------------------

TECH STACK

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MapStruct
- MySQL 
- Maven

--------------------------------------------------

API ENDPOINTS

1) Create User
POST /api/users

Request Body:
{
  "name": "Mehvish Fansopkar",
  "email": "mehvish@example.com",
  "role": "ADMIN"
}

Response:
201 CREATED

--------------------------------------------------

2) Get Users (Pagination + Sorting)
GET /api/users?pageNo=0&pageSize=10&sortDir=ASC&sortField=createdAt

Query Parameters:
- pageNo     : Page number (0-based)
- pageSize   : Number of records per page
- sortDir    : Sort direction (ASC / DESC)
- sortField  : Field to sort by

--------------------------------------------------

3) Get User by Email
GET /api/users/{email}

--------------------------------------------------

EXCEPTION HANDLING

The API uses centralized exception handling via ControllerAdvice.

- Email already exists → 409 CONFLICT
- User not found → 404 NOT FOUND
- Validation error → 400 BAD REQUEST

Validation errors return field-level messages for easy frontend integration.

--------------------------------------------------

DESIGN HIGHLIGHTS

- Layered Architecture
  Controller → Service → Repository

- DTO-based API Design
  Prevents entity exposure and improves maintainability

- Pagination and Sorting at Database Level
  Implemented using Pageable and Sort

- Database Indexing
  Email column indexed and enforced as unique to ensure fast lookups and data integrity

- Centralized Exception Handling
  Keeps controllers clean and ensures consistent error responses

--------------------------------------------------

PROJECT STRUCTURE

controller
service
repository
dto
model
exception

--------------------------------------------------

HOW TO RUN

1. Clone the repository
2. Configure database (MySQL)
3. Run the Spring Boot application
4. Test APIs using Postman or any REST client

--------------------------------------------------

AUTHOR

Mehvish Fansopkar
Software Engineer (Backend)
Java | Spring Boot | REST APIs | SQL
