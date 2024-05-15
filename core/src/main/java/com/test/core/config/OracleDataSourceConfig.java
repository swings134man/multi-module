package com.test.core.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@ConditionalOnProperty(prefix = "db.source.oracle", name = "enabled", havingValue = "true", matchIfMissing = false) // 지정된 속성이 존재하는 경우에만 빈을 등록(havingValue 와 일치해야함), matchIfMissing : 속성이 없는 경우에도 빈을 등록할지 여부
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
