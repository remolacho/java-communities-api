package com.communities.infraestructure.tenant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public String resolveCurrentTenantIdentifier() {
        String currentTenant = TenantContext.getCurrentTenant();

        if(!Objects.equals(currentTenant, null)){
            logger.info("Se ejecuta el resolve ############## " + currentTenant);
        }

        return (currentTenant != null) ? currentTenant : "public";
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
