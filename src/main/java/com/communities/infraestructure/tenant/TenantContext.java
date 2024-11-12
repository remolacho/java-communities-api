package com.communities.infraestructure.tenant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TenantContext {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();
    protected static final Log logger = LogFactory.getLog(TenantContext.class);

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        logger.info("Se limpia el contexto ########### " + getCurrentTenant());
        currentTenant.remove();
    }
}
