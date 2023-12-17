package com.test.core.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.test.core.log"},
        entityManagerFactoryRef = "oraEntityManagerFactory",
        transactionManagerRef = "oraTransactionManager"
)
public class OracleDataSourceConfig {

    @Bean(name = "oraDataSource")
    @Qualifier("oraDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-oracle.hikari")
    public DataSource oraDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }


    @Bean(name = "oraEntityManagerFactory")
    @Qualifier("oraEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean oraEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(oraDataSource());
        em.setPackagesToScan("com.test.core.log");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean(name = "oraTransactionManager")
    @Qualifier("oraTransactionManager")
    public JpaTransactionManager oraTransaction() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(oraEntityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
