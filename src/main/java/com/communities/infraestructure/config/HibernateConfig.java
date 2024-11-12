package com.communities.infraestructure.config;

import com.communities.infraestructure.tenant.TenantConnectionProvider;
import com.communities.infraestructure.tenant.TenantSchemaResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class HibernateConfig {
    private final DataSource dataSource;
    private final TenantSchemaResolver tenantSchemaResolver;

    public HibernateConfig(DataSource dataSource, TenantSchemaResolver tenantSchemaResolver) {
        this.dataSource = dataSource;
        this.tenantSchemaResolver = tenantSchemaResolver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.communities.domain.entities");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.multiTenancy", "SCHEMA");
        jpaProperties.put("hibernate.tenant_identifier_resolver", tenantSchemaResolver);
        jpaProperties.put("hibernate.multi_tenant_connection_provider", new TenantConnectionProvider(dataSource));

        emf.setJpaPropertyMap(jpaProperties);
        return emf;
    }
}