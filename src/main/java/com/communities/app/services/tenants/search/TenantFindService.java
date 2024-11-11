package com.communities.app.services.tenants.search;

import com.communities.domain.dao.ITenant;
import com.communities.domain.entities.Tenant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantFindService implements ITenantFindService {
    public final ITenant tenant;

    public TenantFindService(ITenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public Optional<Tenant> findBySubdomain(String subdomain) {
        return tenant.findBySubdomain(subdomain);
    }
}
