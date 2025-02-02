# Doclab - Find the Nearest Doctor

## Project Overview
Doclab is a web application designed to help users find the nearest doctors based on their location. It provides an efficient and user-friendly platform for searching and booking appointments with healthcare professionals. The system utilizes geolocation services, intelligent algorithms, and a comprehensive database to deliver accurate and relevant doctor information to users.

## Features
- **User Registration & Authentication**: Secure login and registration for doctors, patients, and administrators.
- **Location-Based Search**: Find nearby doctors using geolocation services.
- **Doctor Profiles**: Detailed profiles with qualifications, specialties, availability, and patient reviews.
- **Appointment Booking**: Users can book appointments directly through the platform.
- **Admin Dashboard**: Manage doctors, patients, and appointments efficiently.
- **Doctor Dashboard**: Doctors can manage their appointments and patient records.
- **Patient Dashboard**: Patients can view their appointments and medical history.
- **Review System**: Patients can provide ratings and feedback on doctors.

## Technologies Used
### Frontend
- HTML, CSS, JavaScript

### Backend
- Java
- JSP/Servlets
- JDBC for database connectivity

### Database
- MySQL

### APIs & Services
- Geolocation API
- Email Notification System

## Installation & Setup
### Prerequisites
- Java JDK 8 or later
- MySQL Database
- Apache Tomcat Server
- Eclipse/Visual Studio
- JDBC driver for mysql: link *https://dev.mysql.com/downloads/connector/j/*

### Steps to Set Up
1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/doclab.git
   ```
2. **Setup MySQL Database:**
   - Create a database named `vamsi`.
   - Here's the SQL script for setting up your **Vamsi** database with tables and sample data:

```sql
CREATE DATABASE doclab;
USE doclab;

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    location VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    experience INT NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATETIME NOT NULL,
    issue VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE
);

CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 10),
    review_text TEXT,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE
);

INSERT INTO doctors (name, specialty, location, email, phone, experience, password) VALUES
('Dr. A Sharma', 'Cardiology', 'New Delhi', 'asharma@example.com', '9876543210', 15, 'password123'),
('Dr. B Gupta', 'Neurology', 'Mumbai', 'bgupta@example.com', '9876543211', 10, 'password456');

INSERT INTO patients (name, email, phone, password) VALUES
('John Doe', 'johndoe@example.com', '9998887770', 'john123'),
('Jane Smith', 'janesmith@example.com', '9998887771', 'jane456');

INSERT INTO appointments (patient_id, doctor_id, appointment_date, issue) VALUES
(1, 1, '2024-02-10 10:30:00', 'Chest Pain'),
(2, 2, '2024-02-12 14:00:00', 'Migraine');

INSERT INTO reviews (patient_id, doctor_id, rating, review_text) VALUES
(1, 1, 9, 'Excellent doctor! Very professional.'),
(2, 2, 8, 'Good experience, very helpful.');
```


3. **Build & Run the Project:**
   - Open the project in Eclipse or IntelliJ.
   - Deploy the project on Tomcat server.
4. **Access the Application:**
   - Open `http://localhost:8080` in your browser.
   - 
5. **Note:- if any problem encounters Check Tomcat port number, table creation process and getConnection part in all servlet codes and JSP codes.**

## Usage Guide
### User Roles
1. **Patients:**
   - Register and login.
   - Search for nearby doctors.
   - Book appointments.
   - View appointment history.
   - Provide feedback & ratings.

2. **Doctors:**
   - Register and login.
   - Manage appointments.
   - View patient details.

3. **Admin:**
   - Manage users (add/edit/remove doctors & patients).
   - Monitor appointments & reviews.

## Future Enhancements
- **Mobile App Integration**
- **AI-based Doctor Recommendations**
- **Online Consultation via Video Call**
- **Medical Record Uploads**

## Contributors
- **Banavathu Vamsi Nayak**

## If any help do you want regarding this project you can reach me out through LinkedIn https://www.linkedin.com/in/vamsinayak/

## Thank You
