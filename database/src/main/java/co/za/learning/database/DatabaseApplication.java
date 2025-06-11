package co.za.learning.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;
import org.h2.tools.Server;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) {
        // Variable to hold H2 server instance
        Server h2Server = null;

        try {
            // Start H2 server on port 1919
            System.out.println("Starting DATABASE MICROSERVICE...");
            h2Server = startH2Server();
            System.out.println("H2 server started on port 1919...");
        } catch (SQLException e) {
            System.err.println("Error starting H2 server: " + e.getMessage());
            e.printStackTrace();
            // Exit application if the H2 server fails to start
            System.exit(1);
        }

        // Add shutdown hook to stop H2 server gracefully
        Server finalH2Server = h2Server; // Required because h2Server must be effectively final
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (finalH2Server != null && finalH2Server.isRunning(true)) {
                finalH2Server.stop();
                System.out.println("H2 server stopped.");
            }
        }));

        // Start Spring Boot application
        SpringApplication.run(DatabaseApplication.class, args);
    }

    private static Server startH2Server() throws SQLException {
        // Create and start the H2 server
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "1919").start();
    }
}
