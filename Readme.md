Key Features
1.	User Registration
•	Allows users to register using an email and password.
•	Includes validation for strong passwords and valid email formats.
2.	User Login
•	Enables users to log in using their registered credentials.
•	Implements secure session handling using JWT (JSON Web Tokens).
3.	Password Hashing
•	Ensures password security by storing hashed passwords using BCrypt.
4.	Role-Based Authorization
•	Supports role-based access (e.g., regular users vs. admins).
•	Protects specific routes based on user roles.

Tech Stack

Backend:
•	Java (with Spring Boot framework)
•	Spring Security for authentication and authorization
•	JWT for token-based authentication
•	BCrypt for password hashing

Database:
•	PostgreSQL

Other Tools:
•	Postman for API testing
•	Docker (optional) for containerization and deployment

src/
├── main/
│   ├── java/com/example/authsystem/
│   │   ├── controller/        # REST controllers for handling requests
│   │   ├── service/           # Business logic
│   │   ├── dto/               # Data Transfer Objects
│   │   ├── repository/        # Database access
│   │   ├── entity/            # Entity classes for database models
│   │   ├── security/          # Security configurations
│   │   └── exception/         # Exception handling
│   └── resources/
│       ├── application.properties  # Application configurations
│       └── schema.sql              # Database schema (if any)