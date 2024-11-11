package com.communities.app.middleware;

import com.communities.app.exceptions.TenantElementException;
import com.communities.app.services.tenants.search.ITenantFindService;
import com.communities.domain.entities.Tenant;
import com.communities.infraestructure.tenant.TenantContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/*")
public class TenantFilter implements Filter {

    private final ITenantFindService tenantFindService;

    // Constructor para la inyección manual
    public TenantFilter(ITenantFindService tenantFindService) {
        this.tenantFindService = tenantFindService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        String subdomain = extractSubdomain(requestURI);

        Tenant tenant = tenantFindService.findBySubdomain(subdomain)
                .orElseThrow(() -> new TenantElementException("Error Subdomain Not Found"));

        TenantContext.setCurrentTenant(tenant.getSubdomain());

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            TenantContext.clear();
        }
    }

    private String extractSubdomain(String requestURI) {
        String[] parts = requestURI.split("/");
        return parts.length > 1 ? parts[1] : null;
    }
}
