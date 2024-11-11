package com.communities.app.middleware;

import com.communities.app.exceptions.TenantElementException;
import com.communities.app.services.tenants.search.ITenantFindService;
import com.communities.domain.entities.Tenant;
import com.communities.infraestructure.tenant.TenantContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Autowired
    private ITenantFindService tenantFindService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String subdomain = extractSubdomain(requestURI);

        tenantSwitch(subdomain);

        System.out.println("Se ejecuta interceptor ###########");

        return true;
    }

    private void tenantSwitch(String subdomain){
        Tenant tenant = tenantFindService.findBySubdomain(subdomain)
                .orElseThrow(() -> new TenantElementException("Error Subdomain Not Found"));

        TenantContext.setCurrentTenant(tenant.getSubdomain());
    }

    private String extractSubdomain(String requestURI) {
        String[] parts = requestURI.split("/");
        return parts.length > 1 ? parts[1] : null;
    }
}
