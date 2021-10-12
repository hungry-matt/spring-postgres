package com.example.springpostgres.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PostgresConfiguration {

    @Value("${app.datasource.postgres.url}")
    private String url;

    @Value("${app.datasource.postgres.username}")
    private String username;

    @Value("${app.datasource.postgres.password}")
    private String password;

    @Value("${app.datasource.postgres.driver}")
    private String driver;

    @Bean(name = "postgresDataSource")
    public JdbcTemplate postgresDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setPoolPreparedStatements(true);
        JdbcTemplate postgres = new JdbcTemplate(dataSource);
        return postgres;
    }

}
