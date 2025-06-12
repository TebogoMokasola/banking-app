package co.za.learning.database.config;

import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Enumeration;

@Configuration
public class config {

    @Bean(destroyMethod = "")
    public DataSource dataSource() throws SQLException, UnknownHostException {
        // Set H2 specific properties
        System.setProperty("h2.bindAddress", "0.0.0.0");

        // Define the base directory for the H2 database
        String userDir = System.getProperty("user.dir");

        // H2 Server arguments
        String[] args = {
                "-tcpPort", "8082",
                "-tcpAllowOthers",
                "-webPort", "8081",
                "-webAllowOthers",
                "-ifNotExists",
                "-baseDir", userDir.concat("/h2db") // Allow external access
        };

        // Start the H2 server
        Server.createTcpServer(args).start();

        // Retrieve a valid IP address that starts with "172.16." or "172.32."
        String localIpAddress = getPreferredIpAddress();
        if (localIpAddress == null) {
            throw new IllegalStateException("No valid IP address found matching the criteria (172.16.* or 172.32.*).");
        }

        System.out.println("Using IP Address for DataSource: " + localIpAddress);

        // Configure the DataSource with the dynamically retrieved IP
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:tcp://" + localIpAddress + ":8082/./h2db/database")
                .username("admin")
                .password("password")
                .build();
    }

    /**
     * Retrieves a preferred IP address starting with "172.16." or "172.32."
     *
     * @return A valid IP address or `null` if no matching IP is found.
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
                    }
                }
            }
        } catch (SocketException e) {
            System.err.println("Failed to retrieve network interfaces: " + e.getMessage());
        }

        return null; // No valid IP found
    }
}
