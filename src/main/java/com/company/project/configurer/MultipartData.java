package com.company.project.configurer;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author LJX
 */
@Configuration
public class MultipartData {

    @Bean
    public DataSource masterDataSource(){
        HikariConfig jdbcConfig = new HikariConfig();
        jdbcConfig.setPoolName("master");
        jdbcConfig.setDriverClassName("com.mysql.jdbc.Driver");
        jdbcConfig.setJdbcUrl("jdbc:mysql://localhost:3306/api_seed?useSSL=false&allowPublicKeyRetrieval=true");
        jdbcConfig.setUsername("root");
        jdbcConfig.setPassword("root");
        return new HikariDataSource(jdbcConfig);
    }

    @Bean
    public DataSource slaveDataSource(){
        HikariConfig jdbcConfig = new HikariConfig();
        jdbcConfig.setPoolName("master");
        jdbcConfig.setDriverClassName("com.mysql.jdbc.Driver");
        jdbcConfig.setJdbcUrl("jdbc:mysql://localhost:3306/api_seed_01?useSSL=false&allowPublicKeyRetrieval=true");
        jdbcConfig.setUsername("root");
        jdbcConfig.setPassword("root");
        return new HikariDataSource(jdbcConfig);

    }
}
