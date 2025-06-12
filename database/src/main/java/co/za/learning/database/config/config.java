package co.za.learning.database.config;
import org.h2.tools.Server;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;

@Configuration
public class config {

    @Bean(destroyMethod = "")
    public DataSource dataSource() throws SQLException, UnknownHostException, SocketException {
        // Set H2 server properties to bind to all network interfaces
        System.setProperty("h2.bindAddress", "0.0.0.0");
        String userDir = System.getProperty("user.dir");

        // Start H2 TCP server
        String[] args = {
                "-tcpPort", "8082",
                "-tcpAllowOthers",
                "-ifNotExists",
                "-baseDir", userDir.concat("/h2db")
        };
        Server.createTcpServer(args).start();

        // Dynamically retrieve the host IP address
        String hostIp = IpAddressUtils.getHostIp();

        // Configure DataSource with host IP
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:tcp://" + hostIp + ":8082/./h2db/database")
                .username("admin")
                .password("password")
                .build();
    }
}
