package com.communities.infraestructure.tenant;

public class TenantContext {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        System.out.println("Se limpia el contexto ########### " + getCurrentTenant());
        currentTenant.remove();
    }
}