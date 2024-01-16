# Bharat Auto Check - Vehicle Management System

## Overview
Bharat Auto Check is a Java Spring Boot application designed for managing vehicle records. It provides RESTful APIs for CRUD (Create, Read, Update, Delete) operations on vehicle data.

## Installation and Usage

### Table of Contents
- Getting Started
- Endpoints
- Usage
- Contributing
- License

### Getting Started
To run this project locally, follow these steps:

1. **Clone the repository to your local machine:**
   ```bash
   git clone https://github.com/your-username/BharatAutoCheck.git


## Endpoints

### Get All Vehicles
- **URL**: `/vehicle/all`
- **Method**: GET
- **Description**: Retrieves all vehicles.
- **Response**: List of vehicles in JSON.

### Get Vehicle by ID
- **URL**: `/vehicle/find/{id}`
- **Method**: GET
- **Description**: Retrieves a vehicle by ID.
- **Response**: Vehicle details in JSON.

### Add New Vehicle
- **URL**: `/vehicle/add`
- **Method**: POST
- **Description**: Adds a new vehicle.
- **Request Body**: Vehicle details in JSON.
- **Response**: Added vehicle details in JSON.

### Update Vehicle
- **URL**: `/vehicle/update`
- **Method**: PUT
- **Description**: Updates an existing vehicle.
- **Request Body**: Updated vehicle details in JSON.
- **Response**: Updated vehicle details in JSON.

### Delete Vehicle
- **URL**: `/vehicle/delete/{id}`
- **Method**: DELETE
- **Description**: Deletes a vehicle by ID.
- **Response**: HTTP status OK (200) with no content.

