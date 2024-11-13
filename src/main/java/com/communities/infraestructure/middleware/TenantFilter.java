package com.communities.infraestructure.middleware;

import com.communities.infraestructure.tenant.TenantContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Order(1)
@WebFilter("/*")
public class TenantFilter implements Filter {
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        String subdomain = extractSubdomain(requestURI);

        tenantSwitch(subdomain);
        logger.info("Se ejecuta el filter ############ " + TenantContext.getCurrentTenant());

        try{
            filterChain.doFilter(servletRequest, servletResponse);
        }finally{
            TenantContext.clear();
        }
    }

    private void tenantSwitch(String subdomain){
        TenantContext.setCurrentTenant(subdomain);
    }

    private String extractSubdomain(String requestURI) {
        String[] parts = requestURI.split("/");
        return parts.length > 1 ? parts[1] : null;
    }
}
