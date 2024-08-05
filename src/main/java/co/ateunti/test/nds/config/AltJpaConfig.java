package co.ateunti.test.nds.config;

import co.ateunti.test.nds.domain.AltSample;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "co.ateunti.test.nds.alt.repository",
        entityManagerFactoryRef = "altEntityManagerFactory",
        transactionManagerRef = "altTransactionManager"
)
public class AltJpaConfig {

    @Bean
    @Qualifier("altEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean altEntityManagerFactory(
            @Qualifier("altds") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages(AltSample.class)
                .build();
    }

    @Bean
    @Qualifier("altTransactionManager")
    public PlatformTransactionManager altTransactionManager(
            @Qualifier("altEntityManagerFactory") LocalContainerEntityManagerFactoryBean altEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(altEntityManagerFactory.getObject()));
    }
}
