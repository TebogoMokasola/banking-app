package co.za.learning.database.config;

import org.h2.tools.Server;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class H2DBConfiguration {
    @Bean
    public DataSource inMemoryH2DatabaseServer() throws SQLException {
        String userDir = System.getProperty("user.dir");
        System.setProperty("h2.bindAddress", "0.0.0.0");
        final String[] args = {"-tcpPort", "9002", "-ifNotExists", "-baseDir", userDir.concat("/h2db")};
        Server server = Server.createTcpServer(args);
        System.out.println("============starting===============");
        server.start();
        return DataSourceBuilder.create().url("jdbc:h2:tcp://localhost:9002/banking-db")
                .username("admin")
                .password("password")
                .build();

    }
}
