# WhatsApp Business Integration

This project is a Spring Boot application that registers users and sends them a WhatsApp message upon successful registration. It uses MongoDB for data storage and Twilio for WhatsApp messaging integration.

## Features
- User registration with first name, last name, and phone number
- Stores user data in MongoDB
- Sends a WhatsApp message to the user after registration using Twilio

## Technologies Used
- Java 11+
- Spring Boot 2.7.x
- MongoDB
- Twilio API (for WhatsApp messaging)
- Maven

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- MongoDB instance (local or remote)
- Twilio account with WhatsApp messaging enabled

### Setup
1. **Clone the repository:**
   ```bash
   git clone <repo-url>
   cd whatsapp-business-integration
   ```
2. **Configure application properties:**
   Edit `application.properties` with your MongoDB URI and Twilio credentials:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/yourdbname
   twilio.account.sid=YOUR_TWILIO_ACCOUNT_SID
   twilio.auth.token=YOUR_TWILIO_AUTH_TOKEN
   twilio.whatsapp.from=whatsapp:+YOUR_TWILIO_WHATSAPP_NUMBER
   ```
3. **Build the project:**
   ```bash
   mvn clean install
   ```
4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## API Usage

### Register a User
- **Endpoint:** `POST /api/register`
- **Request Body:**
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "phoneNumber": "+1234567890"
  }
  ```
- **Response:**
  ```json
  {
    "id": "<generated_id>",
    "firstName": "John",
    "lastName": "Doe",
    "phoneNumber": "+1234567890"
  }
  ```
- **Behavior:**
  - Stores the user in MongoDB
  - Sends a WhatsApp message to the provided phone number: `Hello <firstName>, your registration is successfully done!`

## Project Structure
- `AbcApplication.java`: Main Spring Boot application entry point
- `User.java`: User entity/model
- `UserController.java`: REST controller for user registration
- `UserService.java`: Business logic for registration and WhatsApp notification
- `UserRepository.java`: MongoDB repository interface
- `WhatsAppService.java`: Handles Twilio WhatsApp messaging

## License
This project is licensed under the MIT License. 
