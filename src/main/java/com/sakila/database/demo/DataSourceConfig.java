package com.sakila.database.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Configure the datasource using environment variables (production), or fallback values (dev) to automate the deployment using actions
 */
@Configuration
public class DataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

        String hostName = envOr("RDS_HOSTNAME", "localhost");
        String port = envOr("RDS_PORT", "33061");
        String dbName = envOr("RDS_DB_NAME", "sakila");
        String username = envOr("RDS_USERNAME", "root");
        String pass = envOr("RDS_PASSWORD", "root");

        String url = String.format("jdbc:mysql://%s:%s/%s", hostName, port, dbName);

        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(pass);

        LOGGER.info("Using data source config:\n  url={}\n  username={}\n  pass={}", url, username, pass);

        return dataSourceBuilder.build();
    }

    /**
     * Get an environment variable with the given key, or default to a fallback value if no value is found
     * @param key The name of the environment variable
     * @param fallback The default value to use if no value is found
     * @return The value of the environment variable, or the fallback value
     */
    private String envOr(String key, String fallback) {
        String value = System.getenv(key);
        return value != null ? value : fallback;
    }
}
