package cn.brainysoon.superhouse.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by brainy on 17-2-17.
 */
@Configuration
public class DataConfig {
    private static final String MYSQL_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String MYSQL_HOST = "localhost";
    private static final String MYSQL_URL = "jdbc:mysql://" + MYSQL_HOST + ":3306/superhouse?useUnicode=true&characterEncoding=UTF-8";
    private static final String MYSQL_USER_NAME = "dbworker";
    private static final String MYSQL_USER_PASSWORD = "dbroom1411DB-";

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {

        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource mysqlDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(MYSQL_DRIVER_CLASS_NAME);
        dataSource.setUrl(MYSQL_URL);
        dataSource.setUsername(MYSQL_USER_NAME);
        dataSource.setPassword(MYSQL_USER_PASSWORD);

        return dataSource;
    }
}
