# iCET - Demo Spring Boot Application - (04)

This project is a Java Spring Boot application designed for academic purposes as a Customer Relationship Management (CRM) system. It includes functionalities for managing products with a RESTful API. The application uses AOP (Aspect-Oriented Programming) to log the execution time of methods.

## Features

- Retrieve all products
- Create new products
- Delete products
- Log the execution time of API methods

## Technologies Used

- Java 17
- Spring Boot 3.2.5
- Spring AOP
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17
- Maven

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/demo-crm.git
    cd demo-crm
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

## API Endpoints

### Retrieve all products

- **URL:** `/products/all/{transactionAmount}/{transactionType}`
- **Method:** `GET`
- **Response:**

    ```json
    {
      "name": "Ravindu"
    }
    ```

### Create new products

- **URL:** `/products/create`
- **Method:** `POST`
- **Response:**

    ```json
    {
      "name": "Ravindu"
    }
    ```

### Delete products

- **URL:** `/products/delete`
- **Method:** `DELETE`
- **Response:**

    ```json
    {
      "name": "Ravindu"
    }
    ```

## Learning Purposes

This project is designed to help you learn the following concepts and best practices in Java Spring Boot development:

1. **Dependency Injection:**
    - **Types:** Field Injection, Constructor Injection, and Setter Injection.
    - **Best Practices:** Constructor Injection is recommended for its convenience in unit testing.
    - **Lazy Loading:** Using `@Lazy` to delay the creation of a bean until it is needed.

    ```java
    @Lazy
    ProductService productService;
    ```

2. **RESTful Web Services:**
    - Creating RESTful APIs using Spring Boot's `@RestController` and handling different HTTP methods with `@GetMapping`, `@PostMapping`, and `@DeleteMapping`.
    - Using `@RequestMapping` to define the base URL for a controller.

    ```java
    @GetMapping("/all/{transactionAmount}/{transactionType}")
    ```

3. **Aspect-Oriented Programming (AOP):**
    - Custom Annotations: Creating custom annotations like `@LogOperationTime`.
    - Logging Execution Time: Using AOP to log the execution time of methods.

    ```java
    @Around("@annotation(edu.icet.crm.util.LogOperationTime)")
    ```

4. **Logging:**
    - Using `@Slf4j` from Lombok to add a logger to the classes.
    - Logging important information for auditing purposes.

    ```java
    log.info("Transaction Received. Payment Amount {} and Transaction Type {} ", transactionAmount, transactionType);
    ```

5. **Service Layer:**
    - Defining service interfaces and implementing them.
    - Using `@Service` to define a service class.

    ```java
    public class ProductServiceImpl implements ProductService {
    ```

6. **Spring Boot Annotations:**
    - `@SpringBootApplication` to mark the main class of a Spring Boot application.
    - `@Component`, `@Service`, `@Repository` for defining beans.
    - `@Autowired` for dependency injection.

    ```java
    @SpringBootApplication
    public class Main {
    ```

## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   └── edu/icet/crm/
│   │       ├── Main.java
│   │       ├── controller/
│   │       │   └── ProductController.java
│   │       ├── service/
│   │       │   ├── ProductService.java
│   │       │   └── impl/
│   │       │       └── ProductServiceImpl.java
│   │       ├── util/
│   │       │   ├── LogOperationTime.java
│   │       │   └── aspect/
│   │       │       └── LogOperationTimeAspect.java
│   └── resources/
│       ├── application.yml
│       └── static/
│       └── templates/
├── test/
│   └── java/
│       └── edu/icet/crm/
│           └── MainTests.java
└── pom.xml
