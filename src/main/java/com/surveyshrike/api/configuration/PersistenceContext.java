//package com.surveyshrike.api.configuration;
//
//import java.util.Properties;
//
//import javax.activation.DataSource;
//
//import org.hibernate.cfg.Environment;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//@Configuration
//public class PersistenceContext {
//
//	@Bean(destroyMethod = "close")
//    DataSource dataSource(Environment env) {
//		Properties properties = env.getProperties();
//        HikariConfig dataSourceConfig = new HikariConfig();
//        dataSourceConfig.setDriverClassName(properties.getProperty("db.driver"));
//        dataSourceConfig.setJdbcUrl(properties.getProperty("db.url"));
//        dataSourceConfig.setUsername(properties.getProperty("db.username"));
//        dataSourceConfig.setPassword(properties.getProperty("db.password"));
// 
//        return (DataSource) new HikariDataSource(dataSourceConfig);
//    }
//
//}
