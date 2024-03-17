# SITAS Luggage Management API

Welcome to the SITAS Luggage Management API documentation!

## Overview

The SITAS Luggage Management API is a Spring Boot application designed to handle luggage-related operations within the SITAS ecosystem. This API provides endpoints to manage various aspects of luggage, including creation, retrieval, updating, and deletion.

## Technologies Used

- Java
- Spring Boot 3.2.3
- Maven

## Getting Started

To get started with the SITAS Luggage Management API, follow these steps:

1. **Clone the Repository**: Clone the project repository to your local machine.
2. **Build the Project**: Navigate to the project directory and build the project using Maven or your preferred build tool.
3. **Run the Application**: Run the Spring Boot application

4. **Access the API**: Once the application is running, you can access the API endpoints using tools like Postman or by integrating it into your application.

## API Endpoints

The following are the main endpoints provided by the SITAS Luggage Management API:

- `GET /sitas/luggage`: Retrieve all luggage items.
- `GET /sitas/luggage/{id}`: Retrieve a specific luggage item by ID.
- `POST /sitas/luggage`: Create a new luggage item.
- `PUT /sitas/luggage/{id}`: Update an existing luggage item.
- `DELETE /sitas/luggage/{id}`: Delete a luggage item by ID.
- `GET /sitas/placement-area`: Retrieve all placement area items.
- `GET /sitas/placement-area/{id}`: Retrieve a specific placement area item by ID.

## Documentation

For detailed information on each endpoint, refer to the API documentation
locally using Swagger:
- `http://localhost:8080/sitas/doc/swagger-ui.html`.

## Contributing

Contributions to the SITAS Luggage Management API are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).


