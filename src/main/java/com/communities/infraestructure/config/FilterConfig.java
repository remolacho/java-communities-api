package com.communities.infraestructure.config;

import com.communities.app.middleware.TenantFilter;
import com.communities.app.services.tenants.search.ITenantFindService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    private final ITenantFindService tenantFindService;

    public FilterConfig(ITenantFindService tenantFindService) {
        this.tenantFindService = tenantFindService;
    }

    @Bean
    public FilterRegistrationBean<TenantFilter> tenantFilter() {
        FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TenantFilter(tenantFindService));
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
