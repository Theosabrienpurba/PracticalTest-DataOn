# Meeting Management Application

A simple Spring Boot application for managing meetings with features to create meetings, book attendance, and approve bookings. Frontend is rendered using Thymeleaf + Bootstrap 5, and data is stored in a MySQL database via Spring Data JPA.

## Prerequisites

* Java 17+
* Maven 3.6+
* MySQL server running

## Setup MySQL Database

1. **Create a database**:

   ```sql
   CREATE DATABASE meeting_db;
   ```
2. **Configure credentials** in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/meeting_db?useSSL=false&serverTimezone=UTC
   spring.datasource.username=YOUR_MYSQL_USER
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   ```

## Build & Run

From the project root directory, run:

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on port **8080** by default.

## Accessing the Application

* **Main UI**: [http://localhost:8080/meetings](http://localhost:8080/meetings)

* **H2 Console** (if using H2 dev profile): [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

  * JDBC URL: `jdbc:h2:mem:testdb`
  * User: `sa`
  * Password: *(leave blank)*

## Features

* **Create Meeting**: Fill out the form at the top of the page.
* **List Meetings**: All created meetings are displayed as Bootstrap cards.
* **Book Meeting**: Enter your name & email under a meeting card and click **Book**.
* **Approve Booking**: Admin can approve pending bookings by clicking **Approve** next to each entry.

## Project Structure

```
src/main/java/com/example/meetingmanagement/  # Java source code
  ├── MeetingManagementApplication.java      # Spring Boot entry point
  ├── model/                                 # JPA entities: Meeting & Booking
  ├── repository/                            # Spring Data JPA repos
  └── controller/                            # MVC controllers

src/main/resources/
  ├── application.properties                # Database & JPA config
  ├── templates/meetings.html                # Thymeleaf template
  └── static/
      ├── css/custom.css                    # Custom styles
      └── js/custom.js                      # Custom scripts
```

## Customization

* **Change port**: set `server.port` in `application.properties`.
* **Switch DB**: adjust JDBC URL and driver in `application.properties`.
* **Frontend**: modify `templates/meetings.html`, `static/css/custom.css`, or `static/js/custom.js`.

## Capture
![image](https://github.com/user-attachments/assets/71912202-a464-4ce5-82ae-68b2d90b4c14)

