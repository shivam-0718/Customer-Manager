# Customer Manager Application

It is a comprehensive Spring Boot web application for managing customer information with full CRUD operations. 
This application provides a clean, modern web interface for adding, viewing, updating, and deleting customer records.

## 🚀 Features

- **Customer Management**: Complete CRUD operations for customer records
- **Modern UI**: Responsive web interface with contemporary design
- **Data Persistence**: JPA/Hibernate integration with database storage
- **Form Validation**: Client-side and server-side validation
- **Confirmation Dialogs**: Safe deletion with user confirmation
- **Responsive Design**: Mobile-friendly interface

# 🛠️ Tech Stack

This project leverages a robust set of technologies across different layers to ensure scalability, maintainability, and a seamless user experience.

| Category                | Technology                    | Description                          |
|-------------------------|-------------------------------|--------------------------------------|
| **Backend** | Java 17+                      | Core programming language            |
|                         | Spring Boot 3.x               | Opinionated application framework    |
|                         | Spring MVC                    | Robust web layer framework           |
|                         | Spring Data JPA               | Simplified data access layer         |
|                         | Hibernate                     | Powerful ORM framework               |
|                         | Jakarta Persistence API (JPA) | Standard for object-relational mapping |
| **Frontend** | Thymeleaf                     | Server-side templating engine        |
|                         | HTML5 & CSS3                  | Modern web standards for structure and styling |
|                         | Responsive Design             | Mobile-first approach for all devices |
| **Database** | MySQL                         | Production-ready relational database |
| **Tools & Libraries** | Lombok                        | Reduces boilerplate code (e.g., getters/setters) |
|                         | Maven                         | Project dependency management and build automation |
|                         | Spring Boot DevTools          | Enhances development productivity and hot-reloading |
## 📋 Prerequisites

| Requirement | Version/Details |
|-------------|-----------------|
| **Java** | 17 or higher |
| **Maven** | 3.6+ |
| **IDE** | IntelliJ IDEA, Eclipse, VS Code |
| **Web Browser** | Chrome, Edge, Firefox |

## 🛠️ Installation

**Backend Installation with IntelliJ IDEA**
1. Open IntelliJ IDEA and select "Open" project.
2. Navigate to the `Customer-Manager` directory.
3. Ensure Java 17 is installed and configured.
4. Click **Run > Run 'CustomerManagerApplication'**.

**Backend Installation with VS Code**
1. Open VS Code and select "Open Folder".
2. Navigate to the `Customer-Manager` directory.
3. Install the "Extension Pack for Java" if not already installed.
4. Open the integrated terminal and run:
   ```bash
   mvn spring-boot:run
   ```

**Alternative Installation via Command Line**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/customer-manager.git
   cd customer-manager
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

**Access the Application**
Open your browser and navigate to:
```
http://localhost:8080/customer-info
```
## 📁 Project Structure

```
customer-manager/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/customermanager/
│   │   │       ├── model/
│   │   │       │   └── Customer.java
│   │   │       ├── repo/
│   │   │       │   └── ICustomerRepo.java
│   │   │       ├── service/
│   │   │       │   ├── ICustomerService.java
│   │   │       │   └── CustomerService.java
│   │   │       ├── web/
│   │   │       │   └── CustomerController.java
│   │   │       └── CustomerManagerApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── customerinfo.html
│   │       │   └── showform.html
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🎯 Application Flow

### 1. View Customers
- **URL**: `GET /customer-info`
- **Description**: Displays all customers in a responsive table
- **Features**: Update and delete buttons for each customer

### 2. Add New Customer
- **URL**: `GET /show-form`
- **Description**: Shows form for adding new customer
- **Fields**: First Name, Last Name, City
- **Validation**: All fields are required

### 3. Register Customer
- **URL**: `POST /register-customer`
- **Description**: Processes form submission to save customer
- **Redirect**: Returns to customer list after successful save

### 4. Update Customer
- **URL**: `GET /update-form?customerId={id}`
- **Description**: Pre-populates form with existing customer data
- **Process**: Uses same form as add, but with existing data

### 5. Delete Customer
- **URL**: `GET /delete-data?customerId={id}`
- **Description**: Removes customer after confirmation
- **Safety**: JavaScript confirmation dialog prevents accidental deletion

## 🗄️ Database Schema

### Customer Table
| Column | Type | Constraints |
|--------|------|-------------|
| Customer_id | INTEGER | PRIMARY KEY, AUTO_INCREMENT |
| First_Name | VARCHAR(255) | NOT NULL |
| Last_Name | VARCHAR(255) | NOT NULL |
| City | VARCHAR(255) | NOT NULL |

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/customer-info` | Display all customers |
| GET | `/show-form` | Show add customer form |
| POST | `/register-customer` | Save/update customer |
| GET | `/update-form?customerId={id}` | Show update form |
| GET | `/delete-data?customerId={id}` | Delete customer |

## ⚙️ Configuration

### Database Configuration (application.properties)
```properties
# mySQL Database 
spring.datasource.url=jdbc:mysql://localhost:3306/{database_name}
spring.datasource.username={your_username}
spring.datasource.password={your_password}

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🧪 Testing

### Run Tests
```bash
mvn test
```

### Test Coverage
- Unit tests for service layer
- Integration tests for repository layer
- Web layer tests for controllers

## 🚀 Deployment

### JAR Deployment
```bash
mvn clean package
java -jar target/customer-manager-1.0.0.jar
```

### Docker Deployment
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/customer-manager-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🔮 Future Enhancements

- [ ] Search and filter functionality
- [ ] Pagination for large datasets
- [ ] REST API endpoints
- [ ] Authentication and authorization
- [ ] Email and phone number fields
- [ ] Data export (CSV, PDF)
- [ ] Audit logging
- [ ] Unit and integration tests

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Your Name**
- GitHub: [@shivam-0718](https://github.com/shivam-0718)
- LinkedIn: [Shivam Vyas](https://www.linkedin.com/in/shivam-vyas-1807/)
- Email: shivam.vyas.1807@gmail.com

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Thymeleaf community for the templating engine
- Bootstrap for responsive design inspiration
- All contributors and testers

---

## 📞 Support

If you encounter any issues or have questions, please:
1. Check the [Issues](https://github.com/yourusername/customer-manager/issues) section
2. Create a new issue if your problem isn't already reported
3. Provide detailed information about your environment and the issue

**Happy Coding! 🎉**