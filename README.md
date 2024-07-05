# RentACar Spring Boot Project

## Description
This project is a backend service for a car rental system. It allows users to manage brands, models, and cars. The project is built using the Spring Boot framework and uses PostgreSQL as the database.

## Technologies Used
- **Framework**: Spring Boot
- **Database**: PostgreSQL
- **API Documentation**: Swagger

## Prerequisites
Before running the project, ensure you have the following installed:
- Java Development Kit (JDK) 8 or later
- PostgreSQL
- Maven

## Getting Started

### Clone the Repository
```sh
git clone https://github.com/yourusername/rentacar-springboot-project.git
cd rentacar-springboot-project
```

### Configure the Database
1. Create a PostgreSQL database.
2. Update the `application.properties` file with your database configuration.
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

### Build and Run the Project
```sh
mvn clean install
mvn spring-boot:run
```

### Accessing the Application
- **Swagger UI**: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

## Project Structure
- **src/main/java**: Contains the source code of the project.
  - **controller**: REST controllers to handle HTTP requests.
  - **service**: Service layer containing business logic.
  - **repository**: Interfaces for database access.
  - **model**: Entity classes representing the database tables.

## API Endpoints
### Brand
- **GET** /brands: Retrieve all brands.
- **POST** /brands: Create a new brand.
- **GET** /brands/{id}: Retrieve a specific brand by ID.
- **PUT** /brands/{id}: Update a specific brand by ID.
- **DELETE** /brands/{id}: Delete a specific brand by ID.

### Model
- **GET** /models: Retrieve all models.
- **POST** /models: Create a new model.
- **GET** /models/{id}: Retrieve a specific model by ID.
- **PUT** /models/{id}: Update a specific model by ID.
- **DELETE** /models/{id}: Delete a specific model by ID.

### Car
- **GET** /cars: Retrieve all cars.
- **POST** /cars: Create a new car.
- **GET** /cars/{id}: Retrieve a specific car by ID.
- **PUT** /cars/{id}: Update a specific car by ID.
- **DELETE** /cars/{id}: Delete a specific car by ID.

## Contribution
Contributions are welcome! Please open an issue or submit a pull request for any improvements.

## License
This project is licensed under the MIT License.

## Contact
For any inquiries, please contact [yourname@example.com](mailto:yourname@example.com).

