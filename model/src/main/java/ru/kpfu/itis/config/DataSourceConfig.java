package ru.kpfu.itis.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value = "classpath:database.properties", ignoreResourceNotFound = true)
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("org.postgresql.Driver");
        dataSource.setDriverClass(env.getProperty("jdbc.driver"));
//        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/booksquare");
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
//        dataSource.setUser("postgres");
        dataSource.setUser(env.getProperty("jdbc.user"));
//        dataSource.setPassword("postgres");
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

}