package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@Profile({"initial-sql-import"})
public class ApplicationConfigurationInitialSqlImport {

    private final DataSource dataSource;

    @Value("classpath:initial-script.sql")
    private Resource initialData;

    public ApplicationConfigurationInitialSqlImport(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    InitializingBean initDatabase() {
        return () -> {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator(
                    initialData
            );
            DatabasePopulatorUtils.execute(populator, dataSource);
        };
    }
}
