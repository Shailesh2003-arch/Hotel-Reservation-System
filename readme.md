# Hotel Reservation System

A simple Java console-based application that allows users to manage hotel room reservations using JDBC and MySQL.

## Features

- Reserve a room
- View all reservations
- Get room number using Reservation ID and Guest Name
- Update reservation details
- Delete reservations
- Exit system with a friendly shutdown animation

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL Database

## Database Schema

### Reservation Table

| Column Name      | Data Type                         |
| ---------------- | --------------------------------- |
| reservation_id   | INT (Primary Key, Auto Increment) |
| guest_name       | VARCHAR                           |
| room_number      | INT                               |
| contact_number   | VARCHAR                           |
| reservation_date | TIMESTAMP                         |

## How to Run

1. Clone the repository.
2. Create the MySQL database and `reservation` table.
3. Update the database credentials in the source code:
   - Database URL
   - Username
   - Password

4. Add MySQL JDBC Driver to the project.
5. Compile and run the application.

## Menu Options

```text
1. Reserve a Room
2. View Reservations
3. Get Room Number
4. Update Reservation
5. Delete Reservation
0. Exit
```

## Learning Outcomes

This project helped in understanding:

- JDBC Connectivity
- SQL CRUD Operations
- ResultSet Handling
- Exception Handling
- User Input Management with Scanner
- Database-driven Java Applications

## Future Improvements

- Use PreparedStatement to prevent SQL Injection
- Add room availability checks
- Implement user authentication
- Follow layered architecture (DAO, Service, UI)
- Add logging and validation

---

Built using Java and MySQL.
