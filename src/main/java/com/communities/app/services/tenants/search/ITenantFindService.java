package com.communities.app.services.tenants.search;

import com.communities.domain.entities.Tenant;

import java.util.Optional;

public interface ITenantFindService {
    public Optional<Tenant> findBySubdomain(String subdomain);
}
