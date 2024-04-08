# Random Chuck Norris Joke Text-to-Speech 

## Description
Random Chuck Norris Joke Text-to-Speech is a web application that connects to two external APIs. The application fetches a random Chuck Norris joke and converts the text into speech. Upon displaying the text, the application adds the randomly fetched joke to a PostgreSQL database. This application combines humor with technology, providing users with entertaining Chuck Norris jokes while demonstrating integration with a database.

## Technologies Used
- **Java 17**: Utilized for backend development to leverage the latest features and enhancements.
- **Spring Boot**: Employed for rapid development of the application with features such as MVC architecture.
- **JUnit5, Mockito**: Utilized for writing and executing unit tests to ensure code reliability and quality.
- **Hibernate**: Utilized as the ORM (Object-Relational Mapping) framework for interacting with the PostgreSQL database.
- **Lombok**: Used to reduce boilerplate code and increase code readability.
- **Maven**: Build automation tool used for managing dependencies and project build process.
- **OkHttp, Gson, HTTP**: Used for making HTTP requests and handling JSON data from external APIs.
- **Docker, Docker-Compose & Docker Desktop**: Containerization technology employed for easy deployment and scalability.
- **PostgreSQL, pgAdmin**: Database management system used for storing application data, with pgAdmin for database administration.
- **HTML, CSS, Thymeleaf**: Frontend technologies utilized for creating user interfaces and rendering dynamic content.
- **SQL**: Standard language used for interacting with relational databases.
- **IntelliJ**: Integrated Development Environment (IDE) of choice for development, providing advanced features and productivity tools.
- **Git, GitHub**: Version control system and collaborative platform used for managing source code and facilitating collaboration.

## Installation and Usage
1. Clone the repository from GitHub.
2. Ensure Docker and Docker-Compose are installed on your system.
3. Navigate to the project directory and run `docker-compose up` to start the application.
4. Access the application via the provided endpoint and enjoy random Chuck Norris jokes in speech format.
5. Explore the PostgreSQL database to view the added jokes.

