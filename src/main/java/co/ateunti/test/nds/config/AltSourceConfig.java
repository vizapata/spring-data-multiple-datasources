package co.ateunti.test.nds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AltSourceConfig {

    @Bean
    @ConfigurationProperties("spring.altdb.datasource")
    public DataSourceProperties altDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("altds")
    public DataSource altDataSource() {
        return altDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
