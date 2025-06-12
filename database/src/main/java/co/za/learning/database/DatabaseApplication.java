package co.za.learning.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) {
        System.out.println("Starting DATABASE MICROSERVICE...");

        // Start Spring Boot application
        SpringApplication.run(DatabaseApplication.class, args);

        System.out.println("DATABASE MICROSERVICE STARTED...");
    }
}
