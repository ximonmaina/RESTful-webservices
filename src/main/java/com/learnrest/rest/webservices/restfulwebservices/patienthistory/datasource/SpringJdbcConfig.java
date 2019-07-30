package com.learnrest.rest.webservices.restfulwebservices.patienthistory.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.learnrest.rest.webservices.restfulwebservices.patienthistory.datasource")
public class SpringJdbcConfig {

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/patient_management_system");
        dataSource.setUsername("root");
        dataSource.setPassword("Maina1234");

        return dataSource;
    }
}
