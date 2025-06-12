package co.za.learning.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) {
        System.out.println("Starting DATABASE MICROSERVICE...");

        // Start Spring Boot application and get the application context
        ApplicationContext context = SpringApplication.run(DatabaseApplication.class, args);

        // Access the Spring Environment to get host and port
        Environment environment = context.getBean(Environment.class);
        
        String port = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path", "");

        String localIpAddress = getPreferredIpAddress();
        String host = localIpAddress; // Replace with your public IP or domain if hosting externally
        if (localIpAddress == null) {
            System.err.println("No valid IP address found matching the criteria. Exiting...");
            System.exit(1); // Exit if no valid IP found
        }

        System.out.println("Using IP Address: " + localIpAddress);

        // Customize and set the spring.datasource.url property
        SpringApplication app = new SpringApplication(DatabaseApplication.class);
        app.addInitializers(applicationContext -> {
            ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
            configurableEnvironment.getSystemProperties().put(
                "spring.datasource.url",
                "jdbc:h2:tcp://" + localIpAddress + ":8082/./h2db/database"
            );
        });

        // Construct and display the full URL
        String baseUrl = "http://" + host + ":" + port + contextPath;
        System.out.println("Access the service at: " + baseUrl + "/h2-console");

        // Access the DataSource bean
        DataSource dataSource = context.getBean(DataSource.class);

        // Confirm DataSource initialization
        System.out.println("DataSource initialized: " + dataSource);

        // Access a database connection
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Successfully connected to the database: " + connection.getMetaData().getURL());
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }

        System.out.println("DATABASE MICROSERVICE STARTED...");
    }

    /**
     * Retrieves the preferred IP address based on the specified criteria.
     *
     * @return A valid IP address starting with "172.16." or "172.32.", or null if none is found.
     */
    private static String getPreferredIpAddress() {
        try {
            // Iterate through all network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                // Skip loopback or inactive interfaces
                if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    String ip = inetAddress.getHostAddress();

                    // Match IP address prefixes
                    if (ip.startsWith("172.16.") || ip.startsWith("172.32.")) {
                        return ip; // Return the first valid IP found
                    }else {
                    	return "NO IP Sleceted";
                    }
                }
            }
        } catch (SocketException e) {
            System.err.println("Failed to retrieve network interfaces: " + e.getMessage());
        }

        return null; // No valid IP found
    }
}
