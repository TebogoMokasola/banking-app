package co.za.learning.database.config;
import org.h2.tools.Server;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class config {

    private Server server;

    @Bean
    public DataSource inMemoryH2DatabaseServer() throws SQLException {
        String userDir = System.getProperty("user.dir");
        Properties properties = new Properties();
        properties.setProperty("h2.bindAddress", "0.0.0.0");
        System.setProperties(properties);
        final String[] args = {"-tcpPort", "9002", "-ifNotExists", "-baseDir", userDir.concat("/h2db")};
        server = Server.createTcpServer(args);
        System.out.println("============starting===============");
        server.start();
        return DataSourceBuilder.create().url("jdbc:h2:tcp://localhost:9002/database-engine")
                .username("admin")
                .password("")
                .build();

    }
}